package com.sklay.bean;

import java.io.Serializable;
import java.util.Date;

public class UserGroup implements Serializable
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
	 * 属性title
	 */
	private String title;
	
	/**
	 * 常量COL_TITLE
	 */
	public static final String COL_TITLE = "TITLE";

	/**
	 * 获取title属性
	 */
	public String getTitle()
	{
		return this.title;
	}
	
	/**
	 * 设置title属性
	 */
	public void setTitle(String title)
	{
		this.title = title;
	}
	
	/**
	 * 属性description
	 */
	private String description;
	
	/**
	 * 常量COL_DESCRIPTION
	 */
	public static final String COL_DESCRIPTION = "DESCRIPTION";

	/**
	 * 获取description属性
	 */
	public String getDescription()
	{
		return this.description;
	}
	
	/**
	 * 设置description属性
	 */
	public void setDescription(String description)
	{
		this.description = description;
	}
	
	/**
	 * 属性announcement
	 */
	private String announcement;
	
	/**
	 * 常量COL_ANNOUNCEMENT
	 */
	public static final String COL_ANNOUNCEMENT = "ANNOUNCEMENT";

	/**
	 * 获取announcement属性
	 */
	public String getAnnouncement()
	{
		return this.announcement;
	}
	
	/**
	 * 设置announcement属性
	 */
	public void setAnnouncement(String announcement)
	{
		this.announcement = announcement;
	}
	
	/**
	 * 属性maxMember
	 */
	private int maxMember;
	
	/**
	 * 常量COL_MAX_MEMBER
	 */
	public static final String COL_MAX_MEMBER = "MAX_MEMBER";

	/**
	 * 获取maxMember属性
	 */
	public int getMaxMember()
	{
		return this.maxMember;
	}
	
	/**
	 * 设置maxMember属性
	 */
	public void setMaxMember(int maxMember)
	{
		this.maxMember = maxMember;
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

