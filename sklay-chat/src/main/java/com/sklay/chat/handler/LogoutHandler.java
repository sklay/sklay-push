package com.sklay.chat.handler;

import javax.annotation.Resource;

import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 退出连接实现
 * 
 * @author 3979434@qq.com
 */
public class LogoutHandler implements CIMRequestHandler
{
    
    @Resource
    private DefaultSessionManager defaultSessionManager;
    
    public ReplyBody process(CIMSession ios, SentBody message)
    {
        
        // DefaultSessionManager sessionManager =
        // ((DefaultSessionManager)ContextHolder.getBean("defaultSessionManager"));
        
        String account = ios.getAttribute(CIMConstant.SESSION_KEY).toString();
        ios.removeAttribute(CIMConstant.SESSION_KEY);
        ios.close(true);
        
        defaultSessionManager.removeSession(account);
        
        return null;
    }
}