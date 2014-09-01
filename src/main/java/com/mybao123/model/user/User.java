package com.mybao123.model.user;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mybao123.model.Item;
import com.mybao123.model.organization.Organization;
/**
 * �û���
 * @author Owen
 *
 */
@Entity(name = "t_user")
public class User extends Item 
{
	@Column(name = "nameType")
	@Enumerated
	private  UserNameTypeEnum  nameType;
	
	@Column
	private String psd;
	
	@ManyToOne(optional=true)
	@JoinColumn(name="orgId")
	private Organization org;
	
	@Column
	private boolean used;
	
	@Column
	private String Sex;
	
	@Column
	private String email;
	
	@Column
	private String nickName;
	
	@Column
	private Date birth;
	
	public UserNameTypeEnum getNameType()
	{
		return this.nameType;
	}
	
	public void setNameType(UserNameTypeEnum nameType)
	{
		this.nameType =nameType;
	}

	public Date getbirth()
	{
		return this.birth;
	}

	public void setbirth(Date birth)
	{
		this.birth=birth;
	}
	
	public String getnickName()
	{
		return this.nickName;
	}

	public void setnickName(String nickName)
	{
		this.nickName=nickName;
	}


	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email=email;
	}

	public String getSex()
	{
		return this.Sex;
	}

	public void setSex(String Sex)
	{
		this.Sex=Sex;
	}
	public String getPsd()
	{
		return this.psd;
	}

	public void setPsd(String psd)
	{
		this.psd=psd;
	}

	
	
	public Organization getOrg()
	{
		return this.org;
	}

	public void setOrg(Organization org)
	{
		this.org=org;
		
	}

	
	public boolean getUsed()
	{
		return this.used;
	}

	public void setUsed(Boolean used)
	{
		this.used=used;
	}

}
