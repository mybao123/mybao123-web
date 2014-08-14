package com.mybao123.model;
/**
 * 树形节点接口
 * @author Owen
 *
 * @param <T>
 */
public interface INode<T extends IItem>
{
	/**获取父节点
	 * 
	 * @return
	 */
	T getParent();
	/**
	 * 设置父节点
	 * @param parent
	 */
	void setParent(T parent);
	
	/**
	 * 获取层级
	 * @return
	 */
	int getNLevel();
	/**设置层级
	 * 
	 * @param nLevel
	 */
	void setNLevel(int nLevel);
	/**
	 * 获取全路径
	 * @return
	 */
	String getFullPath();
	/**
	 * 设置全路径
	 * @param fullPath
	 */
	void setFullPath(String fullPath);
	
}
