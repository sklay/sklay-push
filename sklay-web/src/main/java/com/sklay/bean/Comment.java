package com.sklay.bean;

import java.io.Serializable;
import java.util.Date;

public class Comment implements Serializable
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
	 * 属性resourceId
	 */
	private long resourceId;
	
	/**
	 * 常量COL_RESOURCE_ID
	 */
	public static final String COL_RESOURCE_ID = "RESOURCE_ID";

	/**
	 * 获取resourceId属性
	 */
	public long getResourceId()
	{
		return this.resourceId;
	}
	
	/**
	 * 设置resourceId属性
	 */
	public void setResourceId(long resourceId)
	{
		this.resourceId = resourceId;
	}
	
	/**
	 * 属性category
	 */
	private int category;
	
	/**
	 * 常量COL_CATEGORY
	 */
	public static final String COL_CATEGORY = "CATEGORY";

	/**
	 * 获取category属性
	 */
	public int getCategory()
	{
		return this.category;
	}
	
	/**
	 * 设置category属性
	 */
	public void setCategory(int category)
	{
		this.category = category;
	}
	
	/**
	 * 属性commentResourceId
	 */
	private long commentResourceId;
	
	/**
	 * 常量COL_COMMENT_RESOURCE_ID
	 */
	public static final String COL_COMMENT_RESOURCE_ID = "COMMENT_RESOURCE_ID";

	/**
	 * 获取commentResourceId属性
	 */
	public long getCommentResourceId()
	{
		return this.commentResourceId;
	}
	
	/**
	 * 设置commentResourceId属性
	 */
	public void setCommentResourceId(long commentResourceId)
	{
		this.commentResourceId = commentResourceId;
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
	 * 属性content
	 */
	private String content;
	
	/**
	 * 常量COL_CONTENT
	 */
	public static final String COL_CONTENT = "CONTENT";

	/**
	 * 获取content属性
	 */
	public String getContent()
	{
		return this.content;
	}
	
	/**
	 * 设置content属性
	 */
	public void setContent(String content)
	{
		this.content = content;
	}
	
	/**
	 * 属性summary
	 */
	private String summary;
	
	/**
	 * 常量COL_SUMMARY
	 */
	public static final String COL_SUMMARY = "SUMMARY";

	/**
	 * 获取summary属性
	 */
	public String getSummary()
	{
		return this.summary;
	}
	
	/**
	 * 设置summary属性
	 */
	public void setSummary(String summary)
	{
		this.summary = summary;
	}
	
	/**
	 * 属性shortUrl
	 */
	private String shortUrl;
	
	/**
	 * 常量COL_SHORT_URL
	 */
	public static final String COL_SHORT_URL = "SHORT_URL";

	/**
	 * 获取shortUrl属性
	 */
	public String getShortUrl()
	{
		return this.shortUrl;
	}
	
	/**
	 * 设置shortUrl属性
	 */
	public void setShortUrl(String shortUrl)
	{
		this.shortUrl = shortUrl;
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

