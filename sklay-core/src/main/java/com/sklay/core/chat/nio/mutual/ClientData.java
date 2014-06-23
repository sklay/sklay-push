package com.sklay.core.chat.nio.mutual;

import java.io.Serializable;
import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

/**
 * java |android 客户端请求结构
 * 
 * @author 客户端发送消息对象
 */
public class ClientData implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = 4607632466301247362L;
    
    private String key;
    
    /**
     * 账户
     */
    private String account;
    
    /**
     * 设备编号
     */
    private String deviceId;
    
    /**
     * 设备类型
     */
    private String channel;
    
    /**
     * 手机型号
     */
    private String device;
    
    private long timestamp;
    
    public ClientData()
    {
        
        timestamp = System.currentTimeMillis();
    }
    
    public String getKey()
    {
        return key;
    }
    
    public long getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public void setKey(String key)
    {
        this.key = key;
    }
    
    /**
     * @return the account
     */
    public String getAccount()
    {
        return account;
    }
    
    /**
     * @param account the account to set
     */
    public void setAccount(String account)
    {
        this.account = account;
    }
    
    /**
     * @return the deviceId
     */
    public String getDeviceId()
    {
        return deviceId;
    }
    
    /**
     * @param deviceId the deviceId to set
     */
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    /**
     * @return the channel
     */
    public String getChannel()
    {
        return channel;
    }
    
    /**
     * @param channel the channel to set
     */
    public void setChannel(String channel)
    {
        this.channel = channel;
    }
    
    /**
     * @return the device
     */
    public String getDevice()
    {
        return device;
    }
    
    /**
     * @param device the device to set
     */
    public void setDevice(String device)
    {
        this.device = device;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
    
    public String toJSONString()
    {
        return JSONObject.toJSONString(this);
    }
    
}
