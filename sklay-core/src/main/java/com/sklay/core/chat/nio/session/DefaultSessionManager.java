package com.sklay.core.chat.nio.session;

import java.util.Collection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Component;

import com.sklay.core.chat.nio.constant.CIMConstant;

/**
 * 自带默认 session管理实现， 各位可以自行实现 AbstractSessionManager接口来实现自己的 session管理
 * 
 * @author 1988fuyu@163.com
 */
@Component
public class DefaultSessionManager implements SessionManager
{
    private static HashMap<String, CIMSession> sessions = new HashMap<String, CIMSession>();
    
    private static final AtomicInteger connectionsCounter = new AtomicInteger(0);
    
    /**
     *  
     */
    public void addSession(String account, CIMSession session)
    {
        if (session != null)
        {
            session.setAttribute(CIMConstant.SESSION_KEY, account);
            sessions.put(account, session);
            connectionsCounter.incrementAndGet();
        }
        
    }
    
    public CIMSession getSession(String account)
    {
        
        return sessions.get(account);
    }
    
    public Collection<CIMSession> getSessions()
    {
        return sessions.values();
    }
    
    public void removeSession(CIMSession session)
    {
        
        sessions.remove(session.getAttribute(CIMConstant.SESSION_KEY));
    }
    
    public void removeSession(String account)
    {
        
        sessions.remove(account);
        
    }
    
    public boolean containsCIMSession(CIMSession ios)
    {
        return sessions.containsKey(ios.getAttribute(CIMConstant.SESSION_KEY)) || sessions.containsValue(ios);
    }
    
    // TODO
    public String getAccount(CIMSession ios)
    {
        if (ios.getAttribute(CIMConstant.SESSION_KEY) == null)
        {
            for (String key : sessions.keySet())
            {
                if (sessions.get(key).equals(ios) || sessions.get(key).getGid() == ios.getGid())
                {
                    return key;
                }
            }
        }
        else
        {
            return ios.getAttribute(CIMConstant.SESSION_KEY).toString();
        }
        
        return null;
    }
}
