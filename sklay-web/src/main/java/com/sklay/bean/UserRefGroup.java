package com.sklay.bean;

import java.io.Serializable;
import java.util.Date;

public class UserRefGroup implements Serializable
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
	 * 属性gid
	 */
	private long gid;
	
	/**
	 * 常量COL_GID
	 */
	public static final String COL_GID = "GID";

	/**
	 * 获取gid属性
	 */
	public long getGid()
	{
		return this.gid;
	}
	
	/**
	 * 设置gid属性
	 */
	public void setGid(long gid)
	{
		this.gid = gid;
	}
	
	/**
	 * 属性uid
	 */
	private long uid;
	
	/**
	 * 常量COL_UID
	 */
	public static final String COL_UID = "UID";

	/**
	 * 获取uid属性
	 */
	public long getUid()
	{
		return this.uid;
	}
	
	/**
	 * 设置uid属性
	 */
	public void setUid(long uid)
	{
		this.uid = uid;
	}
	
	/**
	 * 属性role
	 */
	private int role;
	
	/**
	 * 常量COL_ROLE
	 */
	public static final String COL_ROLE = "ROLE";

	/**
	 * 获取role属性
	 */
	public int getRole()
	{
		return this.role;
	}
	
	/**
	 * 设置role属性
	 */
	public void setRole(int role)
	{
		this.role = role;
	}
	
	/**
	 * 属性status
	 */
	private int status;
	
	/**
	 * 常量COL_STATUS
	 */
	public static final String COL_STATUS = "STATUS";

	/**
	 * 获取status属性
	 */
	public int getStatus()
	{
		return this.status;
	}
	
	/**
	 * 设置status属性
	 */
	public void setStatus(int status)
	{
		this.status = status;
	}
	
	/**
	 * 属性createTime
	 */
	private Date createTime;
	
	/**
	 * 常量COL_CREATE_TIME
	 */
	public static final String COL_CREATE_TIME = "CREATE_TIME";

	/**
	 * 获取createTime属性
	 */
	public Date getCreateTime()
	{
		return this.createTime;
	}
	
	/**
	 * 设置createTime属性
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	
	/**
	 * 属性creator
	 */
	private long creator;
	
	/**
	 * 常量COL_CREATOR
	 */
	public static final String COL_CREATOR = "CREATOR";

	/**
	 * 获取creator属性
	 */
	public long getCreator()
	{
		return this.creator;
	}
	
	/**
	 * 设置creator属性
	 */
	public void setCreator(long creator)
	{
		this.creator = creator;
	}
	
	/**
	 * 属性updateTime
	 */
	private Date updateTime;
	
	/**
	 * 常量COL_UPDATE_TIME
	 */
	public static final String COL_UPDATE_TIME = "UPDATE_TIME";

	/**
	 * 获取updateTime属性
	 */
	public Date getUpdateTime()
	{
		return this.updateTime;
	}
	
	/**
	 * 设置updateTime属性
	 */
	public void setUpdateTime(Date updateTime)
	{
		this.updateTime = updateTime;
	}
	
	/**
	 * 属性updator
	 */
	private long updator;
	
	/**
	 * 常量COL_UPDATOR
	 */
	public static final String COL_UPDATOR = "UPDATOR";

	/**
	 * 获取updator属性
	 */
	public long getUpdator()
	{
		return this.updator;
	}
	
	/**
	 * 设置updator属性
	 */
	public void setUpdator(long updator)
	{
		this.updator = updator;
	}
	
}

