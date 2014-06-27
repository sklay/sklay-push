package com.sklay.chat.push.impl;

import org.springframework.stereotype.Component;

import com.sklay.core.chat.nio.mutual.Message;

/**
 * 
 * @author
 */
@Component
public class SystemMessagePusher extends DefaultMessagePusher
{
    
    /**
     * Constructor.
     */
    public SystemMessagePusher()
    {
        super();
    }
    
    @Override
    public void pushMessageToUser(Message MessageMO)
    {
        
        MessageMO.setSender("system");
        super.pushMessageToUser(MessageMO);
        
    }
}
