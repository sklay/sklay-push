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
	 * 属性userName
	 */
	private String userName;
	
	/**
	 * 常量COL_USER_NAME
	 */
	public static final String COL_USER_NAME = "USER_NAME";

	/**
	 * 获取userName属性
	 */
	public String getUserName()
	{
		return this.userName;
	}
	
	/**
	 * 设置userName属性
	 */
	public void setUserName(String userName)
	{
		this.userName = userName;
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
	 * 属性userType
	 */
	private int userType;
	
	/**
	 * 常量COL_USER_TYPE
	 */
	public static final String COL_USER_TYPE = "USER_TYPE";

	/**
	 * 获取userType属性
	 */
	public int getUserType()
	{
		return this.userType;
	}
	
	/**
	 * 设置userType属性
	 */
	public void setUserType(int userType)
	{
		this.userType = userType;
	}
	
	/**
	 * 属性name
	 */
	private String name;
	
	/**
	 * 常量COL_NAME
	 */
	public static final String COL_NAME = "NAME";

	/**
	 * 获取name属性
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * 设置name属性
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * 属性gender
	 */
	private int gender;
	
	/**
	 * 常量COL_GENDER
	 */
	public static final String COL_GENDER = "GENDER";

	/**
	 * 获取gender属性
	 */
	public int getGender()
	{
		return this.gender;
	}
	
	/**
	 * 设置gender属性
	 */
	public void setGender(int gender)
	{
		this.gender = gender;
	}
	
	/**
	 * 属性image
	 */
	private String image;
	
	/**
	 * 常量COL_IMAGE
	 */
	public static final String COL_IMAGE = "IMAGE";

	/**
	 * 获取image属性
	 */
	public String getImage()
	{
		return this.image;
	}
	
	/**
	 * 设置image属性
	 */
	public void setImage(String image)
	{
		this.image = image;
	}
	
	/**
	 * 属性birthday
	 */
	private Date birthday;
	
	/**
	 * 常量COL_BIRTHDAY
	 */
	public static final String COL_BIRTHDAY = "BIRTHDAY";

	/**
	 * 获取birthday属性
	 */
	public Date getBirthday()
	{
		return this.birthday;
	}
	
	/**
	 * 设置birthday属性
	 */
	public void setBirthday(Date birthday)
	{
		this.birthday = birthday;
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
	 * 属性qq
	 */
	private String qq;
	
	/**
	 * 常量COL_QQ
	 */
	public static final String COL_QQ = "QQ";

	/**
	 * 获取qq属性
	 */
	public String getQq()
	{
		return this.qq;
	}
	
	/**
	 * 设置qq属性
	 */
	public void setQq(String qq)
	{
		this.qq = qq;
	}
	
	/**
	 * 属性qqToken
	 */
	private String qqToken;
	
	/**
	 * 常量COL_QQ_TOKEN
	 */
	public static final String COL_QQ_TOKEN = "QQ_TOKEN";

	/**
	 * 获取qqToken属性
	 */
	public String getQqToken()
	{
		return this.qqToken;
	}
	
	/**
	 * 设置qqToken属性
	 */
	public void setQqToken(String qqToken)
	{
		this.qqToken = qqToken;
	}
	
	/**
	 * 属性email
	 */
	private String email;
	
	/**
	 * 常量COL_EMAIL
	 */
	public static final String COL_EMAIL = "EMAIL";

	/**
	 * 获取email属性
	 */
	public String getEmail()
	{
		return this.email;
	}
	
	/**
	 * 设置email属性
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}
	
	/**
	 * 属性msn
	 */
	private String msn;
	
	/**
	 * 常量COL_MSN
	 */
	public static final String COL_MSN = "MSN";

	/**
	 * 获取msn属性
	 */
	public String getMsn()
	{
		return this.msn;
	}
	
	/**
	 * 设置msn属性
	 */
	public void setMsn(String msn)
	{
		this.msn = msn;
	}
	
	/**
	 * 属性weibo
	 */
	private String weibo;
	
	/**
	 * 常量COL_WEIBO
	 */
	public static final String COL_WEIBO = "WEIBO";

	/**
	 * 获取weibo属性
	 */
	public String getWeibo()
	{
		return this.weibo;
	}
	
	/**
	 * 设置weibo属性
	 */
	public void setWeibo(String weibo)
	{
		this.weibo = weibo;
	}
	
	/**
	 * 属性weiboToken
	 */
	private String weiboToken;
	
	/**
	 * 常量COL_WEIBO_TOKEN
	 */
	public static final String COL_WEIBO_TOKEN = "WEIBO_TOKEN";

	/**
	 * 获取weiboToken属性
	 */
	public String getWeiboToken()
	{
		return this.weiboToken;
	}
	
	/**
	 * 设置weiboToken属性
	 */
	public void setWeiboToken(String weiboToken)
	{
		this.weiboToken = weiboToken;
	}
	
	/**
	 * 属性weixin
	 */
	private String weixin;
	
	/**
	 * 常量COL_WEIXIN
	 */
	public static final String COL_WEIXIN = "WEIXIN";

	/**
	 * 获取weixin属性
	 */
	public String getWeixin()
	{
		return this.weixin;
	}
	
	/**
	 * 设置weixin属性
	 */
	public void setWeixin(String weixin)
	{
		this.weixin = weixin;
	}
	
	/**
	 * 属性souhuToken
	 */
	private String souhuToken;
	
	/**
	 * 常量COL_SOUHU_TOKEN
	 */
	public static final String COL_SOUHU_TOKEN = "SOUHU_TOKEN";

	/**
	 * 获取souhuToken属性
	 */
	public String getSouhuToken()
	{
		return this.souhuToken;
	}
	
	/**
	 * 设置souhuToken属性
	 */
	public void setSouhuToken(String souhuToken)
	{
		this.souhuToken = souhuToken;
	}
	
	/**
	 * 属性tel
	 */
	private String tel;
	
	/**
	 * 常量COL_TEL
	 */
	public static final String COL_TEL = "TEL";

	/**
	 * 获取tel属性
	 */
	public String getTel()
	{
		return this.tel;
	}
	
	/**
	 * 设置tel属性
	 */
	public void setTel(String tel)
	{
		this.tel = tel;
	}
	
	/**
	 * 属性province
	 */
	private long province;
	
	/**
	 * 常量COL_PROVINCE
	 */
	public static final String COL_PROVINCE = "PROVINCE";

	/**
	 * 获取province属性
	 */
	public long getProvince()
	{
		return this.province;
	}
	
	/**
	 * 设置province属性
	 */
	public void setProvince(long province)
	{
		this.province = province;
	}
	
	/**
	 * 属性city
	 */
	private long city;
	
	/**
	 * 常量COL_CITY
	 */
	public static final String COL_CITY = "CITY";

	/**
	 * 获取city属性
	 */
	public long getCity()
	{
		return this.city;
	}
	
	/**
	 * 设置city属性
	 */
	public void setCity(long city)
	{
		this.city = city;
	}
	
	/**
	 * 属性area
	 */
	private long area;
	
	/**
	 * 常量COL_AREA
	 */
	public static final String COL_AREA = "AREA";

	/**
	 * 获取area属性
	 */
	public long getArea()
	{
		return this.area;
	}
	
	/**
	 * 设置area属性
	 */
	public void setArea(long area)
	{
		this.area = area;
	}
	
	/**
	 * 属性address
	 */
	private int address;
	
	/**
	 * 常量COL_ADDRESS
	 */
	public static final String COL_ADDRESS = "ADDRESS";

	/**
	 * 获取address属性
	 */
	public int getAddress()
	{
		return this.address;
	}
	
	/**
	 * 设置address属性
	 */
	public void setAddress(int address)
	{
		this.address = address;
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
	private String creator;
	
	/**
	 * 常量COL_CREATOR
	 */
	public static final String COL_CREATOR = "CREATOR";

	/**
	 * 获取creator属性
	 */
	public String getCreator()
	{
		return this.creator;
	}
	
	/**
	 * 设置creator属性
	 */
	public void setCreator(String creator)
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
	private String updator;
	
	/**
	 * 常量COL_UPDATOR
	 */
	public static final String COL_UPDATOR = "UPDATOR";

	/**
	 * 获取updator属性
	 */
	public String getUpdator()
	{
		return this.updator;
	}
	
	/**
	 * 设置updator属性
	 */
	public void setUpdator(String updator)
	{
		this.updator = updator;
	}
	
}

