package com.mybao123.model;

/**
 * ���ݳ־û������ӿ�
 * 
 * @author Owen
 * 
 */
public interface IItem extends IPK
{
	
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
