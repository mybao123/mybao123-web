package com.mybao123.service; 
 
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.stereotype.Service; 
import org.springframework.beans.factory.annotation.Autowired; 

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
		
		User u=(User)userDao.getSession().load(User.class, new Long(3));
		
		//Organization orgs=new Organization();
		
		org.setName("lq");
		org.setLeader(u);
		org.setDescription("123");
		orgDao.getSession().saveOrUpdate(org);
		
		userDao.getSession().saveOrUpdate(u);
	} 
}
