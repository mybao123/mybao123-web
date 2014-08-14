package com.mybao123.model;

/**
 * 数据持久化基础接口
 * 
 * @author Owen
 * 
 */
public interface IItem
{
	/**
	 * 获取主鍵
	 * @return
	 */
	long getId();
	/**
	 * 设置主键
	 * @param id
	 */
	void setId(long id);
	/**
	 * 获取名称
	 * @return
	 */
	String getName();
	/**
	 * 设置名称
	 * @param name
	 */
	void setName(String name);
	/**
	 * 获取描述
	 * @return
	 */
	String getDescription();
	/**
	 * 设置描述
	 * @param description
	 */
	void setDescription(String description);
}
