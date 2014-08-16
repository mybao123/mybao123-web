package com.mybao123.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.mybao123.dao.organization.OrganizationDao;
import com.mybao123.dao.user.UserDao;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;
import com.mybao123.model.user.UserNameTypeEnum;

@Service
public class IndexService extends BaseService
{
	@Autowired
	private UserDao userDao;

	@Autowired
	private OrganizationDao orgDao;
	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional(readOnly=true)
	public void addUser(String name, String number)
	{
		
		
		User u2=new User();
		
		u2.setName("owen");
		u2.setNameType(UserNameTypeEnum.EMail);
		u2.setDescription("OK!");
		u2.setPsd("xyyyyxssss");
		u2.setUsed(true);
		

		User u=(User)userDao.load(7);
		
		String s7=u.getName();
		
		//userDao.getSession().save(u2);
		

		
//		Organization org2=(Organization)orgDao.getSession().load(Organization.class, new Long(14));
//		
//		String so=org2.getName();
//		
//		User u4=org2.getLeader();
//		
//		String s4=u4.getName();
//		
//		User u=(User)userDao.getSession().load(User.class, new Long(7));
//		
//		String s=u.getName();
//		
//		User u3=new User();
//		
//		u3.setName("owen3");
//		u3.setNameType(UserNameTypeEnum.EMail);
//		u3.setDescription("OK!");
//		u3.setPsd("5678");
//		u3.setUsed(true);
//		u3.setId(7);
//		
//		Organization org=new Organization();
//		org.setName("成都市青羊区4");
//		org.setLeader(u3);
//		org.setNLevel(1);
		
		//orgDao.getSession().saveOrUpdate(org);
		
	}
}
