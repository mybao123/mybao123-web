package com.mybao123.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybao123.dao.organization.OrganizationDao;
import com.mybao123.dao.user.UserDao;
import com.mybao123.model.organization.IOrganization;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.IUser;
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
		
		IUser u = new User();
		u.setName(name);

		IOrganization org=new Organization();
		
		org.setName("Âó±£");
		org.setLeader(u);
		org.setDescription("123");
		
		//orgDao.getSession().saveOrUpdate(org);
		
		userDao.getSession().saveOrUpdate(u);
	}
}
