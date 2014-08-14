package com.mybao123.model.user;

import com.mybao123.model.IItem;
import com.mybao123.model.organization.IOrganization;

/**
 * 用户定义接口
 * @author Owen
 *
 */
public interface IUser extends IItem
{
	/**
	 * 获取用户名类型
	 * @return
	 */
	UserNameTypeEnum getNameType();
	/**
	 * 设置用户名类型
	 * @param nameType
	 */
	void setNameType(UserNameTypeEnum nameType);
	
	/**
	 * 获取密码
	 * @return
	 */
	String getPsd();
	/**
	 * 设置密码
	 * @param psd
	 */
	void setPsd(String psd);
	
	/**
	 * 获取组织机构
	 * @return
	 */
	IOrganization getOrg();
	/**
	 * 设置组织机构
	 * @param org
	 */
	void setOrg(IOrganization org);
	/**
	 * 设置是否使用
	 * @return
	 */
	boolean getUsed();
	/**
	 * 获取是否使用
	 * @param used
	 */
	void setUsed(Boolean used);
}
