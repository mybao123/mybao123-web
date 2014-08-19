package com.mybao123.dao;

import java.lang.reflect.ParameterizedType; 
import java.util.List; 

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Repository;

@Repository
public class BaseDao<T> { 
	
	private Class<T> clazz;
	
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	 /**
     * @description 保存对象
     * @param obj 保存的对象
     */
    public void save(T entity) { 
    	sessionFactory.getCurrentSession().save(entity);
    }
    
    /**
     * @description 更新对象
     * @param obj 更新的对象
     */
    public void update(T entity) {
    	sessionFactory.getCurrentSession().update(entity);
    }
     
    
    /**
     * @description 删除对象
     * @param obj 删除的对象 对象要有主键
     */
    public void delete(T entity) {
    	sessionFactory.getCurrentSession().delete(entity);
    }
    
    /**
     * @description 根据id删除对象
     * @param c 删除的对象类型
     * @param id 删除的对象的主键
     */
    public void delete(int id){
        T obj = loadById(id);
        sessionFactory.getCurrentSession().delete(obj);
    }
    
    
    /**
     * @description 保存或更新对象
     * @param obj 保存或更新的对象 有主键则是更新 没有主键则是保存
     */
    public void saveOrUpdate(T entity){
    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }
    
    
    /**
     * @description 根据id查找对象
     * @param c 对象的类
     * @param id 对象的id
     * @return 
     */
    @SuppressWarnings("unchecked")
    public T loadById(long id){
    	Class<T> type= (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];  
		
		T obj=(T)sessionFactory.getCurrentSession().load(type,new Long(id));
		return obj;
    } 
    
    /**
     * 查找列表对象
     */ 
    @SuppressWarnings("unchecked")  
    protected List<T> loadList(String hql) {    
        Query query = sessionFactory.getCurrentSession().createQuery(hql);   
        return query.list();  
    } 
    
    /**
     * @description 查找列表对象,分页对象进行分页
     * @return
     */
    @SuppressWarnings("unchecked")
    public  List<T> loadListWithPage(String hql,Page page) { 
    	
    	 generatePageTotalCount(hql,  page);   
         Query query = sessionFactory.getCurrentSession().createQuery(hql);   
         query.setFirstResult(page.getCurPage());  
         query.setMaxResults(page.getPageSize());  
         return query.list();  
    }
    private void generatePageTotalCount(String originHql,Page page) {  
        String generatedCountHql = "select count(*) " + originHql;  
        Query countQuery = sessionFactory.getCurrentSession().createQuery(generatedCountHql);   
        int totalCount = ((Long) countQuery.uniqueResult()).intValue();  
        page.setTotalRow(totalCount);  
    }  
}