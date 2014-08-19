package com.mybao123.service;

import java.util.List;

import org.hibernate.Criteria;  
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service; 
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

	@Transactional(readOnly=true)
	public void addUser(String name, String number) 
	{ 
		int page =1;
		int pagesize =20; 

		//Pager pager = null;
		Criteria criteria =orgDao.getSession().createCriteria(Organization.class);
		int rowcount = (Integer)criteria.setProjection(Projections.rowCount()).uniqueResult();
		
		criteria.setProjection(null);
		
		//criteria.addOrder(Order.asc("id"));
		criteria.setFirstResult((page-1)*pagesize);
		criteria.setMaxResults(pagesize);
		Object obj = criteria.uniqueResult(); 
		List result=criteria.list();
		
		
		Criteria criterisa = orgDao.getSession().createCriteria(Organization.class);
		Organization org= (Organization)criterisa.setFirstResult(1).setMaxResults(10).list().get(1);
		//Organization orgs=(Organization)orgDao.getSession().load(Organization.class,3);
 
		User u2=new User();
		 
		u2.setName("owen");
		u2.setNameType(UserNameTypeEnum.EMail);
		u2.setDescription("OK!");
		u2.setPsd("xyyyyxssss");
		u2.setUsed(true); 
		 

		User u=(User)userDao.load(7);
		
		String s7=u.getName(); 
		userDao.getSession().saveOrUpdate(u); 
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
//		org.setName("�ɶ���������4");
//		org.setLeader(u3);
//		org.setNLevel(1);
		
		//orgDao.getSession().saveOrUpdate(org);
		
	} 
}
