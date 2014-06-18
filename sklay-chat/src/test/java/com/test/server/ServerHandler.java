package com.test.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IoSession;

/**
 * 服务端逻辑控制类
 * 
 * @author Lancelot He
 * @version $Rev: $, Nov 9, 2009 11:40:36 AM
 */
public class ServerHandler extends IoHandlerAdapter
{
    Object msg;
    
    @Override
    /**
     * 连接创建事件
     */
    public void sessionCreated(IoSession session)
    {
        // 显示客户端的ip和端口
        System.out.println(session.getRemoteAddress().toString());
    }
    
    @Override
    /**
     * 服务端接收客户端发来的信息，并向客户端发消息
     */
    public void messageReceived(IoSession session, Object message)
        throws Exception
    {
        String str = message.toString();
        if (str.trim().equalsIgnoreCase("quit"))
        {
            session.close(true);
            return;
        }
        // 打印客户端传来的消息内容
        System.out.println("接收的客户端信息:" + str);
        // 服务端发送数据到客户端
        sendMsgToClient(session);
        
    }
    
    public void sendMsgToClient(IoSession session)
        throws IOException
    {
        // 服务端发送数据到客户端
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inString = bufferedReader.readLine();
        session.write(inString);
        if (inString.equals("quit"))
        {
            session.close(true);
        }
    }
    
}