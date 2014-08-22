package com.mybao123.model;

/**
 * 基础数据接口
 * 
 * @author Owen
 * 
 */
public interface IItem extends IPK
{
	
	/**
	 *获取 名称
	 * @return
	 */
	String getName();
	/**
	 *设置名称
	 * @param name
	 */
	void setName(String name);
	/**
	 *获取描述
	 * @return
	 */
	String getDescription();
	/**
	 * 设置描述
	 * @param description
	 */
	void setDescription(String description);
}
