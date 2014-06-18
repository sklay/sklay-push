package com.test.client;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * 客户端逻辑控制类
 * 
 * @author Lancelot He
 * @version $Rev: $, Nov 9, 2009 2:54:13 PM
 */
public class ClientHandler extends IoHandlerAdapter
{
    @Override
    /**
     * 客户端接收服务端发来的信息
     */
    public void messageReceived(IoSession session, Object message)
        throws Exception
    {
        System.out.println("接收的服务端信息:" + message.toString());// 显示接收到的消息
    }
    
}
