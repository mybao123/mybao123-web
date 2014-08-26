package com.mybao123.controller;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
 
import com.mybao123.model.user.User;
import com.mybao123.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController
{
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="userLogin.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String userLogin(User user) throws Exception
	{
		JSONObject object = new JSONObject();  
		long uId=0; 
		boolean IsSuceed= false; 
		String message="";
		try
		{ 
			User u = new User();
			if(user==null)
			{   
				message= "传入后台对象为空"; 
			}
			else
			{
				u=userService.loadByNameAndPwd(user.getName(), user.getPsd());
				if(u!=null)
				{
					uId = u.getId();
					IsSuceed = true;
					message = "登录成功";
				}
				else
				{
					message = "账号或者密码错误";
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
	
	@RequestMapping(value="userRegister.do",produces="application/json;charset=UTF-8")
	public @ResponseBody String userRegist(User user) throws Exception
	{
		JSONObject object = new JSONObject();  
		long uId=0; 
		boolean IsSuceed= false; 
		String message="";
		try
		{ 
			if(user==null)
			{   
				message= "传入后台对象为空"; 
			}else if(user.getName()=="")
			{
				message= "请输入用户名"; 
			}else if(user.getName()=="")
			{
				message= "请输入用户名"; 
			}
			else if(user.getPsd()=="")
			{
				message="请输入密码";
			}else
			{
				userService.saveUser(user);
				uId = user.getId();
				if(uId>0)
				{
					IsSuceed= true;
					message="注册成功";
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