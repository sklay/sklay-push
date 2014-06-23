package com.sklay.bean;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable
{
	/**
	 * 主键
	 */
	private long id;
	
	/**
	 * 常量COL_ID
	 */
	public static final String COL_ID = "ID";

	/**
	 * 获取主键
	 */
	public long getId()
	{
		return this.id;
	}
	/**
	 * 设置主键
	 */
	public void setId(long id)
	{
		this.id = id;
	}
	
	/**
	 * 属性username
	 */
	private String username;
	
	/**
	 * 常量COL_USERNAME
	 */
	public static final String COL_USERNAME = "USERNAME";

	/**
	 * 获取username属性
	 */
	public String getUsername()
	{
		return this.username;
	}
	
	/**
	 * 设置username属性
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * 属性password
	 */
	private String password;
	
	/**
	 * 常量COL_PASSWORD
	 */
	public static final String COL_PASSWORD = "PASSWORD";

	/**
	 * 获取password属性
	 */
	public String getPassword()
	{
		return this.password;
	}
	
	/**
	 * 设置password属性
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	
	/**
	 * 属性nickname
	 */
	private String nickname;
	
	/**
	 * 常量COL_NICKNAME
	 */
	public static final String COL_NICKNAME = "NICKNAME";

	/**
	 * 获取nickname属性
	 */
	public String getNickname()
	{
		return this.nickname;
	}
	
	/**
	 * 设置nickname属性
	 */
	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}
	
	/**
	 * 属性phone
	 */
	private String phone;
	
	/**
	 * 常量COL_PHONE
	 */
	public static final String COL_PHONE = "PHONE";

	/**
	 * 获取phone属性
	 */
	public String getPhone()
	{
		return this.phone;
	}
	
	/**
	 * 设置phone属性
	 */
	public void setPhone(String phone)
	{
		this.phone = phone;
	}
	
	/**
	 * 属性createtime
	 */
	private Date createtime;
	
	/**
	 * 常量COL_CREATETIME
	 */
	public static final String COL_CREATETIME = "CREATETIME";

	/**
	 * 获取createtime属性
	 */
	public Date getCreatetime()
	{
		return this.createtime;
	}
	
	/**
	 * 设置createtime属性
	 */
	public void setCreatetime(Date createtime)
	{
		this.createtime = createtime;
	}
	
	/**
	 * 属性updatetime
	 */
	private Date updatetime;
	
	/**
	 * 常量COL_UPDATETIME
	 */
	public static final String COL_UPDATETIME = "UPDATETIME";

	/**
	 * 获取updatetime属性
	 */
	public Date getUpdatetime()
	{
		return this.updatetime;
	}
	
	/**
	 * 设置updatetime属性
	 */
	public void setUpdatetime(Date updatetime)
	{
		this.updatetime = updatetime;
	}
	
}

