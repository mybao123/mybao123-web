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
	@Id
	@GeneratedValue
	private long id;
	@Column
	private String name;
	@Column
	private String description;
	
	
	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id=id;
	}
	
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
	
	public void setDescription(String description)
	{
		this.description=description;
		
	}

}
