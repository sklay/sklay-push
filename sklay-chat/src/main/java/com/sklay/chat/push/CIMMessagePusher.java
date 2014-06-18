package com.sklay.chat.push;

import com.sklay.core.chat.nio.mutual.Message;

/**
 * 消息发送实接口
 * 
 * @author
 */
public interface CIMMessagePusher
{
    
    /**
     * 向用户发送消息
     * 
     * @param msg
     */
    public void pushMessageToUser(Message msg);
    
}
