package com.mybao123.dao.user;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.mybao123.model.Item;
/**
 * 角色
 * @author Owen
 *
 */
@Entity(name="t_Role")
public class Role extends Item
{
	@Column
	private String key;
}
