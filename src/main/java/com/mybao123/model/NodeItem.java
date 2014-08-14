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
	private T parent;
	private int NLevel;
	private String fullPath;
	
	@ManyToOne
	@JoinColumn(name="parentId")
	public T getParent()
	{
		return parent;
	}

	public void setParent(T parent)
	{
		this.parent=parent;
	}

	@Column(name="nLevel")
	public int getNLevel()
	{
		return this.NLevel;
	}

	public void setNLevel(int nLevel)
	{
		this.NLevel=nLevel;
	}

	@Column(name="fullPath")
	public String getFullPath()
	{
		return this.fullPath;
	}

	public void setFullPath(String fullPath)
	{
		this.fullPath=fullPath;
		
	}
	

}
