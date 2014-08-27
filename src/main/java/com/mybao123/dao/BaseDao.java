package com.mybao123.dao;

import java.lang.reflect.ParameterizedType; 
import java.util.List; 

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * dao基础定义
 * @author Owen
 *
 * @param <T>
 */
public  abstract class BaseDao<T> { 
	
	/**
	 * 
	 */
	@Autowired
	private SessionFactory sessionFactory;
	
	 /**
     * @description 淇濆瓨瀵硅薄
     * @param obj 淇濆瓨鐨勫璞�
     */
    public void save(T entity) { 
    	sessionFactory.getCurrentSession().save(entity);
    }
    
    /**
     * @description 鏇存柊瀵硅薄
     * @param obj 鏇存柊鐨勫璞�
     */
    public void update(T entity) {
    	sessionFactory.getCurrentSession().update(entity);
    }
     
    
    /**
     * @description 鍒犻櫎瀵硅薄
     * @param obj 鍒犻櫎鐨勫璞�瀵硅薄瑕佹湁涓婚敭
     */
    public void delete(T entity) {
    	sessionFactory.getCurrentSession().delete(entity);
    }
    
    /**
     * @description 鏍规嵁id鍒犻櫎瀵硅薄
     * @param c 鍒犻櫎鐨勫璞＄被鍨�
     * @param id 鍒犻櫎鐨勫璞＄殑涓婚敭
     */
    public void delete(int id){
        T obj = loadById(id);
        sessionFactory.getCurrentSession().delete(obj);
    }
    
    
    /**
     * @description 淇濆瓨鎴栨洿鏂板璞�
     * @param obj 淇濆瓨鎴栨洿鏂扮殑瀵硅薄 鏈変富閿垯鏄洿鏂�娌℃湁涓婚敭鍒欐槸淇濆瓨
     */
    public void saveOrUpdate(T entity){
    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }
    
    
    /**
     * @description 鏍规嵁id鏌ユ壘瀵硅薄
     * @param c 瀵硅薄鐨勭被
     * @param id 瀵硅薄鐨刬d
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

     * @description 鏌ユ壘鍒楄〃瀵硅薄

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
    public  List<T> loadListWithPage(String hql,String totalHql,PageInfo page) { 
    	
    	 generatePageTotalCount(hql,  page);   
         Query query = sessionFactory.getCurrentSession().createQuery(hql);   
         query.setFirstResult(page.getCurPage());  
         query.setMaxResults(page.getPageSize());  
         return query.list();  
    }
    private void generatePageTotalCount(String originHql,PageInfo page) {  
        String generatedCountHql = "select count(*) " + originHql;  
        Query countQuery = sessionFactory.getCurrentSession().createQuery(generatedCountHql);   
        int totalCount = ((Long) countQuery.uniqueResult()).intValue();  
        page.setTotalRow(totalCount);  
    }  
}
