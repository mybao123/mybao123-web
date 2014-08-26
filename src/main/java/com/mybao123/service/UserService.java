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
	public User loadByNameAndPwd(String uName,String pwd)
	{
		User user = new User();
		String hql = String.format(" from User where name ='{0}' and psd ='{1}'", uName,pwd);
		List<User> userList=userDao.loadList(hql);
		if(userList.size()>0)
		{
			user=userList.get(0);
			return user;
		}
		else
		{
			return null;
		}
	}
}