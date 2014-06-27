package com.sklay.bean;

import java.io.Serializable;
import java.util.Date;

public class NewsRefCategory implements Serializable
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
	 * 属性ncid
	 */
	private long ncid;
	
	/**
	 * 常量COL_NCID
	 */
	public static final String COL_NCID = "NCID";

	/**
	 * 获取ncid属性
	 */
	public long getNcid()
	{
		return this.ncid;
	}
	
	/**
	 * 设置ncid属性
	 */
	public void setNcid(long ncid)
	{
		this.ncid = ncid;
	}
	
	/**
	 * 属性nid
	 */
	private long nid;
	
	/**
	 * 常量COL_NID
	 */
	public static final String COL_NID = "NID";

	/**
	 * 获取nid属性
	 */
	public long getNid()
	{
		return this.nid;
	}
	
	/**
	 * 设置nid属性
	 */
	public void setNid(long nid)
	{
		this.nid = nid;
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

