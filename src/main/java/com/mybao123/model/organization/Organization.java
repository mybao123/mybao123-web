package com.mybao123.model.organization;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.mybao123.model.NodeItem;
import com.mybao123.model.user.IUser;
import com.mybao123.model.user.User;
/**
 * 组织机构定义
 * @author Owen
 *
 */
@Entity(name="t_Org")
public class Organization extends NodeItem<IOrganization> implements IOrganization
{

	private IUser leader;

	@ManyToOne(targetEntity =User.class)
	@JoinColumn(name="leaderId")
	public IUser getLeader()
	{
		return this.leader;
	}

	public void setLeader(IUser leader)
	{
		this.leader=leader;
		
	}

	@Override
	@ManyToOne(targetEntity = Organization.class )
	@JoinColumn(name="orgId")
	public IOrganization getParent()
	{
		return super.getParent();
	}

	@Override
	public void setParent(IOrganization parent)
	{
		super.setParent(parent);
	}


	
}
