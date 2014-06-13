package com.sklay.chat.handler;

import org.apache.mina.core.session.IoSession;

import com.sklay.chat.common.util.ContextHolder;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 退出连接实现
 * 
 * @author 3979434@qq.com
 */
public class LogoutHandler implements CIMRequestHandler
{
    
    public ReplyBody process(IoSession ios, SentBody message)
    {
        
        DefaultSessionManager sessionManager = ((DefaultSessionManager)ContextHolder.getBean("defaultSessionManager"));
        
        String account = ios.getAttribute("account").toString();
        ios.removeAttribute("account");
        ios.close(true);
        
        sessionManager.removeSession(account);
        
        return null;
    }
    
}