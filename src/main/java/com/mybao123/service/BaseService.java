package com.mybao123.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * �������ݷ�����
 * @author Owen
 *
 */
@Service
public abstract class BaseService
{
	@Autowired
	private SessionFactory  sessionFactory;
	
	public SessionFactory getSessionFactory()
	{
		return this.sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory)
	{
		this.sessionFactory=sessionFactory;
	}
	
	public Session getSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
	
}
