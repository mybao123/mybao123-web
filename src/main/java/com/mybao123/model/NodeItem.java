package com.mybao123.model;
/**
 * 树形结构数据抽象类
 * @author Owen
 *
 * @param <T>
 */
public abstract class NodeItem<T extends IItem> extends Item implements INode<T >
{
	private T parent;
	private int NLevel;
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
