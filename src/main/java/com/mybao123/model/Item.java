package com.mybao123.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * 基础数据的抽象类
 * @author Owen
 *
 */
@MappedSuperclass
public abstract class Item implements IItem
{
	
	private long id;
	
	private String name;
	private String description;
	
	@Id
	@GeneratedValue
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id=id;
	}
	@Column
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
		
	}

	public String getDescription()
	{
		return this.description;
	}
	@Column
	public void setDescription(String description)
	{
		this.description=description;
		
	}

}
