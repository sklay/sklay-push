package com.sklay.core.chat.nio.handle;

/**
 *  请求处理接口,所有的请求实现必须实现此接口
 *  @author 3979434@qq.com
 */
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.CIMSession;

public interface CIMRequestHandler
{
    
    public abstract ReplyBody process(CIMSession ios, SentBody message);
}