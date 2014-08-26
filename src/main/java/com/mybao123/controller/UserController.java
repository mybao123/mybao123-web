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

import com.mybao123.dao.RSAUtils;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;
import com.mybao123.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController
{
	@Autowired
	private UserService userService;
	
	
	
	
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="userLogin.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String userLogin(User user) throws Exception
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		JSONObject object = new JSONObject();  
		long uId=0; 
		boolean IsSuceed= false;  
		String message=""; 
		try
		{  
			if(user==null)
			{   
				message= "传入后台对象为空"; 
			}
			else
			{ 
				String dpwd= DecryptUserPwd(user.getPsd());
				if("".equals(dpwd)||dpwd == null)
				{
					message="Rsa解密失败";
				}
				else
				{
					uId=userService.existUser(user.getName(), dpwd);
					if(uId>0)
					{
						User u = new User();
						u.setId(uId);
						u.setName(user.getName()); 
						IsSuceed = true;
						message = "登录成功";
						HttpSession  session = request.getSession(); 
						session.setAttribute("user", u);
						session.setAttribute("username", user.getName());
						session.setAttribute("password", dpwd);
					}
					else
					{
						message = "账号或者密码错误";
					}
				}
			}
			object.accumulate("Id", uId);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
		catch(Exception ex)
		{
			object.accumulate("Id", 0);
			object.accumulate("IsSuceed", false);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
	}
	
	/**
	 *用户注册
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="userRegister.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String userRegist(User user) throws Exception
	{
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		JSONObject object = new JSONObject();  
		long uId=0; 
		boolean IsSuceed= false; 
		String message="";
		try
		{ 
			if(user==null)
			{   
				message= "传入后台对象为空"; 
			}
			//else if("".equals(user.getName()) || user.getName()==null)
			//{
			//	message= "请输入用户名"; 
			//}
			//else if("".equals(user.getPsd()) || user.getPsd()==null)
			//{
			//	message="请输入密码";
			//}
			else
			{
				String pwd = DecryptUserPwd(user.getPsd());
				if("".equals(pwd)||pwd == null)
				{
					message="Rsa解密失败";
				}
				else
				{
					user.setPsd(pwd);
					userService.saveUser(user);
					uId = user.getId();
					if(uId>0)
					{
						IsSuceed= true;
						message="注册成功";
						HttpSession  session = request.getSession(); 
						session.setAttribute("user", user);
						session.setAttribute("username", user.getName());
						session.setAttribute("password", user.getPsd());
					}
				}
			}
			object.accumulate("Id", uId);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
		catch(Exception ex)
		{
			object.accumulate("Id", 0);
			object.accumulate("IsSuceed", false);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		} 
	}
	
	/**
	 * 密码解密
	 * @param pwd
	 * @return
	 */
	private String DecryptUserPwd(String pwd)
	{ 
		try
		{ 

			String privateExponet   = "c4f2f4259062203cd1dab960cfe68ffd57399837a8804d58169e01942fc491dddb31ce29b08a6a393bc8378408fda6201280bbd560a0c68177327d1368a4ba1";
			String modulus  = "88f6ae182d92151ed240e0c7f51136144609dd5ced49f28171ef33af1e3b1d64c7b5939bc0b12e22f3a046168f8890371555e933a2a5714f7b3a858946eea17f";
			RSAUtils rsa = new RSAUtils(); 
			byte[] en_result = new BigInteger(pwd, 16).toByteArray();
			PrivateKey prk =rsa.getPrivateKey(modulus,privateExponet);//获取私钥
			byte[] de_result = RSAUtils.decrypt(prk,en_result);				
			String dpwd=new String(de_result);
			return dpwd;
		}
		catch(Exception ex)
		{
			return "";
		}
	}

	/**
	 * 用户修改基础信息
	 * @param user
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="updateUser.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String userUpdate(User user) throws Exception
	{
		JSONObject object = new JSONObject();  
		long uId=0; 
		boolean IsSuceed= false; 
		String message="";
		try
		{ 
			User u= new User();
			if(user==null)
			{   
				message= "传入后台对象为空"; 
			}
			else
			{
				uId= user.getId();
				if(uId==0)
				{
					message = "获取用户对象主键值失败";
				}
				else
				{
					u.setbirth(user.getbirth());
					u.setDescription(user.getDescription()==null?"":user.getDescription());
					u.setnickName(user.getnickName()==null?"":user.getnickName());
					u.setSex(user.getSex()==null?"":user.getSex());
					if(user.getOrg()!=null)
					{
						Organization org = new Organization();
						org.setId(user.getOrg().getId());
						org.setName(user.getOrg().getName());
						u.setOrg(org);
					}
					userService.saveUser(u);
					IsSuceed= true;
					message="修改成功";
					
				}
			}
			object.accumulate("Id", uId);
			object.accumulate("IsSuceed", IsSuceed);
			object.accumulate("Message", message);
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		}
		catch(Exception ex)
		{ 
			object.accumulate("Id", 0);
			object.accumulate("IsSuceed", false);
			object.accumulate("Message", ex.getMessage());
			String retStr = JSONObject.fromObject(object).toString(); 
			return retStr;
		} 
	}
}