package com.mybao123.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybao123.dao.organization.OrganizationDao;
import com.mybao123.dao.user.UserDao;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;

@Service
public class IndexService
{
	@Autowired
	private UserDao userDao;

	@Autowired
	private OrganizationDao orgDao;
	
	public void addUser(String name, String number)
	{
		
		Organization org=(Organization)orgDao.getSession().load(Organization.class, new Long(3));
		
		User u=(User)userDao.getSession().load(User.class, new Long(3));
		
		//Organization org=new Organization();
		
		org.setName("Âó±£");
		org.setLeader(u);
		org.setDescription("123");
		
		orgDao.getSession().saveOrUpdate(org);
		
		userDao.getSession().saveOrUpdate(u);
	}
}
