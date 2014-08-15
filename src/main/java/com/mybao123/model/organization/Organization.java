package com.mybao123.model.organization;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;




import com.mybao123.model.NodeItem;
import com.mybao123.model.user.User;
/**
 * 组织机构定义
 * @author Owen
 *
 */
@Entity(name="t_org")
public class Organization extends NodeItem<Organization> 
{
	@ManyToOne(targetEntity =User.class,cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH},fetch = FetchType.LAZY )
	@JoinColumn(name="leaderId")
	private User leader;

//	@ManyToOne
//	@JoinColumn(name="parentId")
//	public Organization getParent()
//	{
//		return super.getParent();
//	}
//
//	public void setParent(Organization parent)
//	{
//		super.setParent(parent);
//	}

	
	public User getLeader()
	{
		return this.leader;
	}

	public void setLeader(User leader)
	{
		this.leader=leader;
	}

}
