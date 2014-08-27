package com.mybao123.controller;
 

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 

import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;
import com.mybao123.service.UserService;
import com.mybao123.util.JsonUtils; 

@Controller
@RequestMapping("/User")
public class UserController
{
	@Autowired
	private UserService userService;
 

	/**
	 * 用户修改基础信息
	 * 
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "updateUser.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String userUpdate(User user) throws Exception
	{
		if (user == null)
		{
			return JsonUtils.getJsonObject("[]", false, "数据传输错误");
		}
		if (!(user.getId() > 0))
		{
			return JsonUtils.getJsonObject("[]", false, "用户登录过期，请退出重新登录");
		}
		try
		{
			User u = new User();
			u = userService.loadById(user.getId());
			if (u == null)
			{
				return JsonUtils.getJsonObject("[]", false, "用户信息获取失败");
			}
			u.setbirth(user.getbirth());
			u.setDescription(user.getDescription() == null ? "" : user
					.getDescription());
			u.setnickName(user.getnickName() == null ? "" : user.getnickName());
			u.setSex(user.getSex() == null ? "" : user.getSex());
			if (user.getOrg() != null)
			{
				Organization org = new Organization();
				org.setId(user.getOrg().getId());
				org.setName(user.getOrg().getName());
				u.setOrg(org);
			}
			userService.saveUser(u);
			String jsStr = JSONObject.fromObject(u).toString();
			return JsonUtils.getJsonObject(jsStr, true, "个人资料更新成功");
		} catch (Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, ex.getMessage());
		}
	}

	/**
	 * 获取用户基本信息
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "getUserInfo.do", produces = "application/json;charset=UTF-8")
	public @ResponseBody
	String getUserInfo(long id) throws Exception
	{
		if (id == 0)
		{
			return JsonUtils.getJsonObject("[]", false, "登录过期，请退出重新登录");
		}
		try
		{
			User u = new User();
			u = userService.loadById(id);
			if (u == null)
			{
				return JsonUtils.getJsonObject("[]", false, "用户信息获取失败");
			}
			String jsStr = JSONObject.fromObject(u).toString();
			return JsonUtils.getJsonObject(jsStr, true, "个人资料信息获取成功");
		} catch (Exception ex)
		{
			return JsonUtils.getJsonObject("[]", false, ex.getMessage());
		}
	}
}