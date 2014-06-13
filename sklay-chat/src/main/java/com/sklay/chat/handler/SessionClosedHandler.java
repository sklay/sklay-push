package com.sklay.chat.handler;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.sklay.chat.common.util.ContextHolder;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 断开连接，清除session
 * 
 * @author
 */
public class SessionClosedHandler implements CIMRequestHandler
{
    
    protected final Logger logger = Logger.getLogger(SessionClosedHandler.class);
    
    public ReplyBody process(IoSession ios, SentBody message)
    {
        
        DefaultSessionManager sessionManager = ((DefaultSessionManager)ContextHolder.getBean("defaultSessionManager"));
        
        if (ios.getAttribute("account") == null)
        {
            return null;
        }
        
        String account = ios.getAttribute("account").toString();
        
        sessionManager.removeSession(account);
        
        return null;
    }
    
}