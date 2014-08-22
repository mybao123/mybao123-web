package com.mybao123.model.task;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mybao123.model.Item;
import com.mybao123.model.organization.Organization;
/**
 * 工作类型
 * @author Owen
 *
 */
public class TaskType extends Item
{
	
	
	
	
	/**
	 * 所属组织机构
	 */
	@ManyToOne(optional=true)
	@JoinColumn(name="orgId")
	private Organization org;
	
	/**
	 * 分值
	 */
	@Column
	private int value;
	
	
}
