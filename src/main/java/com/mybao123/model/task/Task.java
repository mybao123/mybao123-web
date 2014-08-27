package com.mybao123.model.task;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mybao123.model.IPK;
import com.mybao123.model.organization.Organization;
import com.mybao123.model.user.User;


/**
 * 工作记录
 * @author Owen
 *
 */
@Entity(name="t_task")
public class Task implements IPK
{

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne(optional=true)
	@JoinColumn(name="userId")
	private User user;

	@ManyToOne(optional=true)
	@JoinColumn(name="taskTypeId")
	private TaskType taskType;
	
	
	@ManyToOne(optional=true)
	@JoinColumn(name="orgId")
	private Organization org;

	@Column
	private  String personName;

	@Column
	private String phoneNo;
	
	@Column
	private Date taskTime;

	@Column
	private String description;

	@Column
	private String address;

	@Column
	private Date createTime;
	/**
	 * 获取主键
	 */
	public long getId()
	{
		return this.id;
	}
	/**
	 * 设置id
	 */
	public void setId(long id)
	{
		this.id=id;
	}

	/**
	 * 获取用户（业务员）
	 * @return
	 */
	public User getUser()
	{
		return user;
	}

	/**
	 * 设置用户
	 * @param user
	 */
	public void setUser(User user)
	{
		this.user = user;
	}

	/**
	 * 获取用户类型
	 * @return
	 */
	public TaskType getTaskType()
	{
		return taskType;
	}

	/**
	 * 设置类型
	 * @param tskType
	 */
	public void settaskType(TaskType taskType)
	{
		this.taskType = taskType;
	}
	/**
	 * 获取组织机构
	 * @return
	 */
	public Organization getOrg()
	{
		return org;
	}
	/**
	 * 设置组织机构
	 * @param org
	 */
	public void setOrg(Organization org)
	{
		this.org = org;
	}
	/**
	 * 获取客户名称
	 */
	public String getPersonName()
	{
		return personName;
	}

	/**
	 * 设置客户名称
	 * @param personName
	 */
	public void setPersonName(String personName)
	{
		this.personName = personName;
	}

	/**
	 * 获取客户电话
	 */
	public String getPhoneNo()
	{
		return phoneNo;
	}

	/**
	 * 设置客户电话
	 * @param phoneNo
	 */
	public void setPhoneNo(String phoneNo)
	{
		this.phoneNo = phoneNo;
	}

	/**
	 * 获取记录时间
	 * 
	 * @return
	 */
	public Date getTaskTime()
	{
		return taskTime;
	}

	/**
	 * 设置记录时间
	 * 
	 * @param taskTime
	 */
	public void setTaskTime(Date taskTime)
	{
		this.taskTime = taskTime;
	}

	/**
	 *获取 文本描述
	 * @return
	 */
	public String getDescription()
	{
		return description;
	}
   /**
    * 设置文本描述
    * @param description
    */
	public void setDescription(String description)
	{
		this.description = description;
	}
	/**
	 *获取 地址
	 * @return
	 */
	public String getAddress()
	{
		return address;
	}
   /**
    * 设置地址
    * @param Address
    */
	public void setAddress(String address)
	{
		this.address = address;
	}
	/**
	 * 获取创建时间
	 * @return
	 */
	public Date getCreateTime()
	{
		return createTime;
	}
	/**
	 * 设置创建时间
	 * @param createTime
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
}
