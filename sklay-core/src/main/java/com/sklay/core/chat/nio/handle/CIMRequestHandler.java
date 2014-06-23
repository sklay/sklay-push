package com.sklay.core.chat.nio.handle;

/**
 *  请求处理接口,所有的请求实现必须实现此接口
 *  @author 3979434@qq.com
 */
import com.sklay.core.chat.nio.mutual.ClientData;
import com.sklay.core.chat.nio.mutual.ServerData;
import com.sklay.core.chat.nio.session.CIMSession;

public interface CIMRequestHandler
{
    
    public abstract ServerData process(CIMSession ios, ClientData message);
}