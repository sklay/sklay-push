package com.sklay.core.chat.nio.mutual;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * 请求应答对象
 * 
 * @author 服务端返回消息对象
 * 
 */
public class ServerData implements Serializable
{
    
    /**
     * 
     */
    private static final long serialVersionUID = -6638174199693288662L;
    
    /**
     * 请求key
     */
    private String key;
    
    /**
     * 返回码
     */
    private String code;
    
    /**
     * 返回说明
     */
    private String message;
    
    private long timestamp;
    
    public ServerData()
    {
        timestamp = System.currentTimeMillis();
    }
    
    public long getTimestamp()
    {
        return timestamp;
    }
    
    public void setTimestamp(long timestamp)
    {
        this.timestamp = timestamp;
    }
    
    public String getKey()
    {
        return key;
    }
    
    public void setKey(String key)
    {
        this.key = key;
    }
    
    public String getMessage()
    {
        return message;
    }
    
    public void setMessage(String message)
    {
        this.message = message;
    }
    
    public String getCode()
    {
        return code;
    }
    
    public void setCode(String code)
    {
        this.code = code;
    }
    
    @Override
    public String toString()
    {
        return JSONObject.toJSONString(this);
    }
    
    public String toJSONString()
    {
        
        return toString();
    }
}
