package com.mybao123.model;

/**
 * �������ݵĳ�����
 * @author Owen
 *
 */
public abstract class Item implements IItem
{
	private long id;
	private String name;
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
