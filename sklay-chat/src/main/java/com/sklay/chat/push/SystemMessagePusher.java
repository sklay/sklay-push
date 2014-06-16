package com.sklay.chat.push;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 
 * @author 1988fuyu@163.com
 */
@Component
public class SystemMessagePusher extends DefaultMessagePusher
{
    @Resource
    private DefaultSessionManager sessionManager;
    
    /**
     * Constructor.
     */
    public SystemMessagePusher()
    {
        super.setSessionManager(sessionManager) ;
//        super();
    }
    
    @Override
    public void pushMessageToUser(Message MessageMO)
    {
        
        MessageMO.setSender("system");
        super.pushMessageToUser(MessageMO);
        
    }
}
