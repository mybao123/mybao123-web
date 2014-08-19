package com.mybao123.model.task;

import java.util.Date;

import javax.persistence.Entity;

import com.mybao123.model.IPK;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;

@Entity(name="t_task")
public class Task implements IPK
{
	/**
	 * ����
	 */
	private long id;
	/**
	 * �û�
	 */
	private User user;
	/**
	 * ��������
	 */
	private Organization org;
	/**
	 * ��ϵ��
	 */
	private  String personName;
	/**
	 * ��ϵ�绰
	 */
	private String phoneNo;
	/**
	 * ��¼ʱ��
	 */
	private Date taskTime;
	/**
	 * 
	 * ����
	 */
	private String description;

	public long getId()
	{
		return this.id;
	}

	public void setId(long id)
	{
		this.id=id;
	}
	
	
}
