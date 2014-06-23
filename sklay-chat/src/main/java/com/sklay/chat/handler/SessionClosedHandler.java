package com.sklay.chat.handler;

import javax.annotation.Resource;

import org.apache.log4j.Logger;

import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.ClientData;
import com.sklay.core.chat.nio.mutual.ServerData;
import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 断开连接，清除session
 * 
 * @author
 */
public class SessionClosedHandler implements CIMRequestHandler
{
    protected final Logger logger = Logger.getLogger(SessionClosedHandler.class);
    
    @Resource
    private DefaultSessionManager defaultSessionManager;
    
    public ServerData process(CIMSession ios, ClientData message)
    {
        
        // DefaultSessionManager sessionManager =
        // ((DefaultSessionManager)ContextHolder.getBean("defaultSessionManager"));
        
        if (ios.getAttribute(CIMConstant.SESSION_KEY) == null)
        {
            return null;
        }
        
        String account = ios.getAttribute(CIMConstant.SESSION_KEY).toString();
        defaultSessionManager.removeSession(account);
        
        return null;
    }
}