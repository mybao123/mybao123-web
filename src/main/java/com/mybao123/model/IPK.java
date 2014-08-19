package com.mybao123.model;

/**
 * 持久化对象的主键
 * @author Owen
 *
 */
public interface IPK
{
	/**
	 * 获取主键id
	 * @return
	 */
	long getId();
	/**
	 * 设置主键id
	 * @param id
	 */
	void setId(long id);
}
