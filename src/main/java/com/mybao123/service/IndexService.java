package com.mybao123.service;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
import org.springframework.transaction.annotation.Transactional; 

import com.mybao123.dao.user.UserDao;

@Service
public class IndexService extends BaseService
{ 

	@Autowired
	private UserDao userDao;
	
	@Transactional(readOnly=true)
	public void addUser(String name, String number) 
	{  
		
	} 
}
