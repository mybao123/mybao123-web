package com.mybao123.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import org.springframework.transaction.annotation.Transactional;

import com.mybao123.dao.user.UserDao;  
import com.mybao123.model.user.User;

@Service
public class UserService
{
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void saveUser(User user)
	{
		userDao.saveOrUpdate(user);
	}
	
	@Transactional
	public User loadById(long id)
	{
		User user = new User();
		user=userDao.loadById(id);
		return user;
	}
	@Transactional
	public int existUser(String name,String pwd)
	{  
		try
		{
			String hql =" select Id from t_user where used= true and  name ='"+name+"' and psd ='"+pwd+"'";
			List<User> userList=userDao.loadList(hql); 
			return userList.size();
		}
		catch(Exception ex){ 
			return 0;
		}
	}
	@Transactional
	public User loadByNameAndPwd(String name, String pwd)
	{
		User u = new User();
		String hql =" select Id from t_user where used= true and  name ='"+name+"' and psd ='"+pwd+"'";
		try
		{
			List<User> userList=userDao.loadList(hql); 
			if(userList.size()>0)
			{
				u.setId(userList.get(0).getId());
				u.setName(userList.get(0).getName()); 
			}
			return u;
		}
		catch(Exception ex){ 
			return u;
		}
	} 
}