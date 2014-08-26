package com.mybao123.controller;

import java.io.File;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey; 

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
			User u = new User();
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
					u=userService.loadByNameAndPwd(user.getName(), dpwd);
					if(u!=null)
					{
						uId = u.getId();
						IsSuceed = true;
						message = "登录成功";
						HttpSession  session = request.getSession(); 
						session.setAttribute("user", u);
						session.setAttribute("username", u.getName());
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
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		try
		{
			String rootPath=request.getSession().getServletContext().getRealPath("/")+"private.key";
			RSAUtils rsa = new RSAUtils(); 
			byte[] en_result = new BigInteger(pwd, 16).toByteArray();
			RSAPrivateKey prk =rsa.getPrivateKey(new File(rootPath));//获取私钥
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