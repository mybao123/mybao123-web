package com.mybao123.model;
/**
 * ���νڵ�ӿ�
 * @author Owen
 *
 * @param <T>
 */
public interface INode<T extends IItem>
{
	/**��ȡ���ڵ�
	 * 
	 * @return
	 */
	T getParent();
	/**
	 * ���ø��ڵ�
	 * @param parent
	 */
	void setParent(T parent);
	
	/**
	 * ��ȡ�㼶
	 * @return
	 */
	int getNLevel();
	/**���ò㼶
	 * 
	 * @param nLevel
	 */
	void setNLevel(int nLevel);
	/**
	 * ��ȡȫ·��
	 * @return
	 */
	String getFullPath();
	/**
	 * ����ȫ·��
	 * @param fullPath
	 */
	void setFullPath(String fullPath);
	
}
