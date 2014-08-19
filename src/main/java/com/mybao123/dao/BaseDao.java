package com.mybao123.dao;

import java.lang.reflect.ParameterizedType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public abstract class BaseDao<T>
{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public SessionFactory getSessionFactory()
	{

		return this.sessionFactory;
	}
	
	public Session getSession()
	{
		return this.sessionFactory.getCurrentSession();
	}
	
	@SuppressWarnings("unchecked")
	public T load(long id)
	{
		Class<T> type= (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];  
		
		T obj=(T)this.getSession().load(type,new Long(id));
		return obj;
	}
}
