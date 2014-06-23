package com.sklay.core.chat.nio.session;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.UnknownHostException;
import java.util.concurrent.TimeUnit;

import org.apache.mina.core.future.WriteFuture;
import org.apache.mina.core.session.IoSession;

import com.sklay.core.chat.nio.constant.CIMConstant;

/**
 * IoSession包装类,集群时 将此对象存入表中
 * 
 * @author 3979434@qq.com
 */

public class CIMSession implements Serializable
{
    
    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    
    public static String ID = "ID";
    
    public static String HOST = "HOST";
    
    private IoSession session;
    
    private String gid;// session全局ID
    
    private Long nid;// session在本台服务器上的ID
    
    private String deviceId;// 客户端设备ID
    
    private String host;// session绑定的服务器IP
    
    private String account;// session绑定的账号
    
    private String channel;// 终端设备类型
    
    private String deviceModel;// 终端设备型号
    
    private Long bindTime;// 登录时间
    
    private Long heartbeat;// 心跳时间
    
    public CIMSession(IoSession session)
    {
        this.session = session;
        this.nid = session.getId();
    }
    
    public CIMSession()
    {
        
    }
    
    public String getAccount()
    {
        return account;
    }
    
    public void setAccount(String account)
    {
        if (session != null)
        {
            session.setAttribute(CIMConstant.SESSION_KEY, account);
        }
        this.account = account;
    }
    
    public String getGid()
    {
        return gid;
    }
    
    public void setGid(String gid)
    {
        this.gid = gid;
    }
    
    public Long getNid()
    {
        return nid;
    }
    
    public void setNid(Long nid)
    {
        this.nid = nid;
    }
    
    public String getDeviceId()
    {
        return deviceId;
    }
    
    public String getChannel()
    {
        return channel;
    }
    
    public void setChannel(String channel)
    {
        this.channel = channel;
    }
    
    public String getDeviceModel()
    {
        return deviceModel;
    }
    
    public void setDeviceModel(String deviceModel)
    {
        this.deviceModel = deviceModel;
    }
    
    public void setDeviceId(String deviceId)
    {
        this.deviceId = deviceId;
    }
    
    public String getHost()
    {
        return host;
    }
    
    public Long getBindTime()
    {
        return bindTime;
    }
    
    public void setBindTime(Long bindTime)
    {
        this.bindTime = bindTime;
    }
    
    public Long getHeartbeat()
    {
        return heartbeat;
    }
    
    public void setHeartbeat(Long heartbeat)
    {
        this.heartbeat = heartbeat;
        if (session != null)
        {
            session.setAttribute(CIMConstant.HEARTBEAT_KEY, heartbeat);
        }
    }
    
    public void setHost(String host)
    {
        this.host = host;
    }
    
    public void setAttribute(String key, Object value)
    {
        if (session != null)
            session.setAttribute(key, value);
    }
    
    /**
     * @return the iD
     */
    public static String getID()
    {
        return ID;
    }
    
    /**
     * @param iD the iD to set
     */
    public static void setID(String iD)
    {
        ID = iD;
    }
    
    /**
     * @return the hOST
     */
    public static String getHOST()
    {
        return HOST;
    }
    
    /**
     * @param hOST the hOST to set
     */
    public static void setHOST(String hOST)
    {
        HOST = hOST;
    }
    
    /**
     * @return the session
     */
    public IoSession getSession()
    {
        return session;
    }
    
    /**
     * @param session the session to set
     */
    public void setSession(IoSession session)
    {
        this.session = session;
    }
    
    /**
     * @return the serialversionuid
     */
    public static long getSerialversionuid()
    {
        return serialVersionUID;
    }
    
    public boolean containsAttribute(String key)
    {
        if (session != null)
            return session.containsAttribute(key);
        return false;
    }
    
    public Object getAttribute(String key)
    {
        if (session != null)
            return session.getAttribute(key);
        return null;
    }
    
    public void removeAttribute(String key)
    {
        if (session != null)
            session.removeAttribute(key);
    }
    
    public SocketAddress getRemoteAddress()
    {
        if (session != null)
            return session.getRemoteAddress();
        return null;
    }
    
    public boolean write(Object msg)
    {
        if (session != null)
        {
            WriteFuture wf = session.write(msg);
            wf.awaitUninterruptibly(5, TimeUnit.SECONDS);
            return wf.isWritten();
        }
        return false;
    }
    
    public boolean isConnected()
    {
        if (session != null)
            return session.isConnected();
        return false;
    }
    
    public boolean isLocalhost()
    {
        
        try
        {
            String ip = InetAddress.getLocalHost().getHostAddress();
            return ip.equals(host) && session != null;
        }
        catch (UnknownHostException e)
        {
            e.printStackTrace();
        }
        return false;
        
    }
    
    public void close(boolean immediately)
    {
        if (session != null)
            session.close(immediately);
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((account == null) ? 0 : account.hashCode());
        result = prime * result + ((bindTime == null) ? 0 : bindTime.hashCode());
        result = prime * result + ((channel == null) ? 0 : channel.hashCode());
        result = prime * result + ((deviceId == null) ? 0 : deviceId.hashCode());
        result = prime * result + ((deviceModel == null) ? 0 : deviceModel.hashCode());
        result = prime * result + ((gid == null) ? 0 : gid.hashCode());
        result = prime * result + ((heartbeat == null) ? 0 : heartbeat.hashCode());
        result = prime * result + ((host == null) ? 0 : host.hashCode());
        result = prime * result + ((nid == null) ? 0 : nid.hashCode());
        result = prime * result + ((session == null) ? 0 : session.hashCode());
        return result;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CIMSession other = (CIMSession)obj;
        if (account == null)
        {
            if (other.account != null)
                return false;
        }
        else if (!account.equals(other.account))
            return false;
        if (bindTime == null)
        {
            if (other.bindTime != null)
                return false;
        }
        else if (!bindTime.equals(other.bindTime))
            return false;
        if (channel == null)
        {
            if (other.channel != null)
                return false;
        }
        else if (!channel.equals(other.channel))
            return false;
        if (deviceId == null)
        {
            if (other.deviceId != null)
                return false;
        }
        else if (!deviceId.equals(other.deviceId))
            return false;
        if (deviceModel == null)
        {
            if (other.deviceModel != null)
                return false;
        }
        else if (!deviceModel.equals(other.deviceModel))
            return false;
        if (gid == null)
        {
            if (other.gid != null)
                return false;
        }
        else if (!gid.equals(other.gid))
            return false;
        if (heartbeat == null)
        {
            if (other.heartbeat != null)
                return false;
        }
        else if (!heartbeat.equals(other.heartbeat))
            return false;
        if (host == null)
        {
            if (other.host != null)
                return false;
        }
        else if (!host.equals(other.host))
            return false;
        if (nid == null)
        {
            if (other.nid != null)
                return false;
        }
        else if (!nid.equals(other.nid))
            return false;
        if (session == null)
        {
            if (other.session != null)
                return false;
        }
        else if (!session.equals(other.session))
            return false;
        return true;
    }
    
    public void setIoSession(IoSession session)
    {
        this.session = session;
    }
    
    public IoSession getIoSession()
    {
        return session;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString()
    {
        return "CIMSession [session=" + session + ", gid=" + gid + ", nid=" + nid + ", deviceId=" + deviceId
            + ", host=" + host + ", account=" + account + ", channel=" + channel + ", deviceModel=" + deviceModel
            + ", bindTime=" + bindTime + ", heartbeat=" + heartbeat + "]";
    }
    
}