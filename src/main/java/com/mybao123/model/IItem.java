package com.mybao123.model;

/**
 * ���ݳ־û������ӿ�
 * 
 * @author Owen
 * 
 */
public interface IItem
{
	/**
	 * ��ȡ���I
	 * @return
	 */
	long getId();
	/**
	 * ��������
	 * @param id
	 */
	void setId(long id);
	/**
	 * ��ȡ����
	 * @return
	 */
	String getName();
	/**
	 * ��������
	 * @param name
	 */
	void setName(String name);
	/**
	 * ��ȡ����
	 * @return
	 */
	String getDescription();
	/**
	 * ��������
	 * @param description
	 */
	void setDescription(String description);
}
