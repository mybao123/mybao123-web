package com.mybao123.model.user;

import com.mybao123.model.IItem;
import com.mybao123.model.organization.IOrganization;

/**
 * �û�����ӿ�
 * @author Owen
 *
 */
public interface IUser extends IItem
{
	/**
	 * ��ȡ�û�������
	 * @return
	 */
	UserNameTypeEnum getNameType();
	/**
	 * �����û�������
	 * @param nameType
	 */
	void setNameType(UserNameTypeEnum nameType);
	
	/**
	 * ��ȡ����
	 * @return
	 */
	String getPsd();
	/**
	 * ��������
	 * @param psd
	 */
	void setPsd(String psd);
	
	/**
	 * ��ȡ��֯����
	 * @return
	 */
	IOrganization getOrg();
	/**
	 * ������֯����
	 * @param org
	 */
	void setOrg(IOrganization org);
	/**
	 * �����Ƿ�ʹ��
	 * @return
	 */
	boolean getUsed();
	/**
	 * ��ȡ�Ƿ�ʹ��
	 * @param used
	 */
	void setUsed(Boolean used);
}
