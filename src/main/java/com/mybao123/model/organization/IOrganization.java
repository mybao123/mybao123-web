package com.mybao123.model.organization;


import javax.persistence.MappedSuperclass;

import com.mybao123.model.IItem;
import com.mybao123.model.INode;
import com.mybao123.model.user.IUser;

/**
 * ��֯�����ӿڶ���
 * @author Owen
 *
 */
public interface IOrganization extends IItem, INode<IOrganization>
{
	/**
	 * ��ȡ�����쵼
	 * @return
	 */
	IUser getLeader();
	/**
	 * ���û����쵼
	 * @param leader
	 */
	void setLeader(IUser leader);
}
