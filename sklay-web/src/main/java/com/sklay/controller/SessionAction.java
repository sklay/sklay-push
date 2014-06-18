package com.sklay.controller;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;
import org.apache.mina.transport.socket.nio.NioSocketConnector;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sklay.chat.handler.BindHandler;
import com.sklay.chat.push.SystemMessagePusher;
import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.filter.ClientMessageCodecFactory;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

@Controller
@RequestMapping("/admin")
public class SessionAction
{
    
    @Resource
    DefaultSessionManager defaultSessionManager;
    
    @Resource
    SystemMessagePusher systemMessagePusher;
    
    @Resource
    NioSocketAcceptor serverAcceptor;
    
    private NioSocketConnector connector;
    
    private ConnectFuture connectFuture;
    
    private IoSession session;
    
    @RequestMapping("/manage")
    public String list(final HttpServletRequest request)
    {
//        login() ;
        request.setAttribute("sessionList", defaultSessionManager.getSessions());
        
        return "session.manage";
    }
    
    @RequestMapping("/offline")
    @ResponseBody
    public void offline(String account)
        throws IOException
    {
        
        Message msg = new Message();
        msg.setType("999");// 强行下线消息类型
        msg.setReceiver(account);
        
        // 向客户端 发送消息
        systemMessagePusher.pushMessageToUser(msg);
        
    }
    
    private void login()
    {
        connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(10 * 1000);
        connector.getSessionConfig().setBothIdleTime(180);
        connector.getSessionConfig().setKeepAlive(true);
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ClientMessageCodecFactory()));
        connector.setHandler(iohandler);
        InetSocketAddress remoteSocketAddress = new InetSocketAddress("127.0.0.1", 23456);
        connectFuture = connector.connect(remoteSocketAddress);
        connectFuture.awaitUninterruptibly();
        session = connectFuture.getSession();
       
        
        SentBody sent = new SentBody();
        sent.setKey(CIMConstant.RequestKey.CLIENT_BIND);
        sent.put("account", "admin");
        sent.put("deviceId", String.valueOf(new Date().getTime()));
        sent.put("channel", "web");
        sent.put("device", "sasasassass");
        
        
        BindHandler bindHandler = new BindHandler() ;
        
//        bindHandler.process(session, sent) ;
//        
//        session = defaultSessionManager.getSession("admin") ;
    }
    
    IoHandlerAdapter iohandler = new IoHandlerAdapter()
    {
        
        @Override
        public void sessionCreated(IoSession session)
            throws Exception
        {
            System.out.println("******************server连接服务器成功:" + session.getLocalAddress());
        }
        
        @Override
        public void sessionOpened(IoSession session)
            throws Exception
        {
            session.getConfig().setBothIdleTime(180);
        }
        
        @Override
        public void sessionClosed(IoSession session)
            throws Exception
        {
            System.out.println("******************server与服务器断开连接:" + session.getLocalAddress());
        }
        
        @Override
        public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception
        {
            
            System.out.println("******************server与服务器连接空闲:" + session.getLocalAddress());
            SentBody sent = new SentBody();
            sent.setKey(CIMConstant.RequestKey.CLIENT_HEARTBEAT);
        }
        
        @Override
        public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception
        {
            System.out.println(" exception " + cause.toString());
        }
        
        @Override
        public void messageReceived(IoSession session, Object obj)
            throws Exception
        {
            
            if (obj instanceof Message)
            {
                
                System.out.println(" Message " + obj.toString());
                
            }
            if (obj instanceof ReplyBody)
            {
                System.out.println(" ReplyBody " + obj.toString());
            }
        }
        
        @Override
        public void messageSent(IoSession session, Object message)
            throws Exception
        {
            
        }
    };
}
