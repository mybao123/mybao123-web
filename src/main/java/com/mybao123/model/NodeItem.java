package com.mybao123.model;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * 树形结构数据抽象类
 * @author Owen
 *
 * @param <T>
 */
@MappedSuperclass
public abstract class NodeItem<T extends IItem> extends Item implements INode<T >
{
	@ManyToOne()
	@JoinColumn(name="parentId")
	private T parent;
	@Column(name="nLevel")
	private int NLevel;
	@Column(name="fullPath")
	private String fullPath;
	
	
	public T getParent()
	{
		return parent;
	}

	public void setParent(T parent)
	{
		this.parent=parent;
	}

	
	public int getNLevel()
	{
		return this.NLevel;
	}

	public void setNLevel(int nLevel)
	{
		this.NLevel=nLevel;
	}

	
	public String getFullPath()
	{
		return this.fullPath;
	}

	public void setFullPath(String fullPath)
	{
		this.fullPath=fullPath;
		
	}
	

}
