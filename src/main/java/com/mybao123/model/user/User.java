package com.mybao123.model.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mybao123.model.Item;
import com.mybao123.model.organization.IOrganization;
import com.mybao123.model.organization.Organization;
/**
 * ”√ªß¿‡
 * @author Owen
 *
 */
@Entity(name = "t_user")
public class User extends Item implements IUser
{
	private  UserNameTypeEnum  nameType;
	private String psd;
	private IOrganization org;
	private boolean used;
	
	@Enumerated(EnumType.STRING)
	public UserNameTypeEnum getNameType()
	{
		return this.nameType;
	}
	
	public void setNameType(UserNameTypeEnum nameType)
	{
		this.nameType =nameType;
	}

	@Column
	public String getPsd()
	{
		return this.psd;
	}

	public void setPsd(String psd)
	{
		this.psd=psd;
	}

	@ManyToOne(targetEntity =Organization.class)
	@JoinColumn(name="orgId")
	public IOrganization getOrg()
	{
		return this.org;
	}

	public void setOrg(IOrganization org)
	{
		this.org=org;
		
	}

	@Column
	public boolean getUsed()
	{
		return this.used;
	}

	public void setUsed(Boolean used)
	{
		this.used=used;
	}

}
