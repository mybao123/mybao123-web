package com.mybao123.model.organization;


import javax.persistence.MappedSuperclass;

import com.mybao123.model.IItem;
import com.mybao123.model.INode;
import com.mybao123.model.user.IUser;

/**
 * 组织机构接口定义
 * @author Owen
 *
 */
public interface IOrganization extends IItem, INode<IOrganization>
{
	/**
	 * 获取机构领导
	 * @return
	 */
	IUser getLeader();
	/**
	 * 设置机构领导
	 * @param leader
	 */
	void setLeader(IUser leader);
}
