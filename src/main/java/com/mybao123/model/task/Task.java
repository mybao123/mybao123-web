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
	 * 主键
	 */
	private long id;
	/**
	 * 用户
	 */
	private User user;
	/**
	 * 所属机构
	 */
	private Organization org;
	/**
	 * 联系人
	 */
	private  String personName;
	/**
	 * 联系电话
	 */
	private String phoneNo;
	/**
	 * 记录时间
	 */
	private Date taskTime;
	/**
	 * 
	 * 描述
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
