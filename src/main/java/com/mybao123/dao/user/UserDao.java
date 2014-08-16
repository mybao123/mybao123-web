package com.mybao123.dao.user;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mybao123.dao.BaseDao;
import com.mybao123.model.user.User;

@Repository
public class UserDao extends BaseDao<User>
{
	
	
	public UserDao()
	{
		
	}

}
