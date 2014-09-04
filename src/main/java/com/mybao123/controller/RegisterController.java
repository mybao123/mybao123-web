package com.mybao123.controller;
import java.math.BigInteger;
import java.security.PrivateKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mybao123.model.user.User;
import com.mybao123.service.UserService;
import com.mybao123.util.JsonUtils;
import com.mybao123.util.RSAUtils;

@Controller
@RequestMapping("Register")
public class RegisterController
{
	@Autowired
	private UserService userService;

	/**
	 * 用户注册
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "userRegister.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String userRegist(User user) throws Exception
	{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
				.getRequestAttributes()).getRequest();
		if (user == null)
		{
			return JsonUtils.getJsonObject("[]", false, "数据传输错误");
		}
		if ("".equals(user.getName()) || user.getName() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "用户名不能为空");
		}
		if ("".equals(user.getPsd()) || user.getPsd() == null)
		{
			return JsonUtils.getJsonObject("[]", false, "密码不能为空");
		}
		try
		{
			String pwd = DecryptUserPwd(user.getPsd());
			if ("".equals(pwd) || pwd == null)
			{
				return JsonUtils.getJsonObject("[]", false, "密码不能为空");
			}

			// 判断是否存在！
			int c = userService.existUser(user.getName(), pwd);
			if (c > 0)
			{
				return JsonUtils.getJsonObject("[]", false, user.getName()
						+ "的用户已存在，请修改用户名");
			}
			user.setPsd(pwd);
			userService.saveUser(user);
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			String jsStr = JSONObject.fromObject(user).toString();
			return JsonUtils.getJsonObject(jsStr, true,
					"注册成功，已将验证消息发送到相关终端，请注意查收");
		} catch (Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, "密码不能为空");
		}
	}

	/**
	 * 密码解密
	 * 
	 * @param pwd
	 * @return
	 */
	private String DecryptUserPwd(String pwd)
	{
		try
		{
			byte[] en_result = new BigInteger(pwd, 16).toByteArray();
			PrivateKey prk = RSAUtils.getPrivateKey();// 获取私钥
			byte[] de_result = RSAUtils.decrypt(prk, en_result);
			String dpwd = new String(de_result);
			return dpwd;
		} catch (Exception ex)
		{
			return "";
		}
	}
}