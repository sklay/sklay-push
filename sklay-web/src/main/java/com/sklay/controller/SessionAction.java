package com.sklay.controller;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.core.future.WriteFuture;
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

import com.sklay.chat.push.SystemMessagePusher;
import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.filter.ClientMessageCodecFactory;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.CIMSession;
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
        // login() ;
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
    
    @RequestMapping("/login")
    @ResponseBody
    private void login()
    {
        connector = new NioSocketConnector();
        connector.setConnectTimeoutMillis(10 * 1000);
        connector.getSessionConfig().setBothIdleTime(180);
        connector.getSessionConfig().setKeepAlive(true);
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        connector.getFilterChain().addLast("codec", new ProtocolCodecFilter(new ClientMessageCodecFactory()));
        connector.setHandler(iohandler);
        InetSocketAddress remoteSocketAddress = new InetSocketAddress("192.168.1.166", 23456);
        connectFuture = connector.connect(remoteSocketAddress);
        connectFuture.awaitUninterruptibly();
        session = connectFuture.getSession();
        
        SentBody sent = new SentBody();
        
        sent.setKey(CIMConstant.RequestKey.CLIENT_BIND);
        sent.put("account", "admin");
        sent.put("deviceId", "1234567890");
        sent.put("channel", "web");
        sent.put("device", "sasasassass");
        
        CIMSession cimSession = new CIMSession(session);
        process(cimSession, sent);
        //
        // session = defaultSessionManager.getSession("admin") ;
    }
    
    IoHandlerAdapter iohandler = new IoHandlerAdapter()
    {
        
        @Override
        public void sessionCreated(IoSession session)
            throws Exception
        {
            System.out.println("******************WEB 连接服务器成功:" + session.getLocalAddress());
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
            
            System.out.println("******************WEB 与服务器断开连接:" + session.getLocalAddress());
            // if (CIMConnectorManager.this.session.getId() == session.getId())
            // {
            //
            // Intent intent = new Intent();
            // intent.setAction(ACTION_CONNECTION_CLOSED);
            // context.sendBroadcast(intent);
            //
            // }
        }
        
        @Override
        public void sessionIdle(IoSession session, IdleStatus status)
            throws Exception
        {
            
            System.out.println("******************WEB 与服务器连接空闲:" + session.getLocalAddress());
            SentBody sent = new SentBody();
            sent.setKey(CIMConstant.RequestKey.CLIENT_HEARTBEAT);
            // send(sent);
            
            if (session != null && session.isConnected())
            {
                WriteFuture wf = session.write(sent);
                // 消息发送超时 10秒
                wf.awaitUninterruptibly(5, TimeUnit.SECONDS);
                
                if (!wf.isWritten())
                {
                    System.out.println("******************WEB 空闲消息无法发出");
                }
            }
        }
        
        @Override
        public void exceptionCaught(IoSession session, Throwable cause)
            throws Exception
        {
            
            System.out.println("******************WEB cause " + cause);
        }
        
        @Override
        public void messageReceived(IoSession session, Object obj)
            throws Exception
        {
            
            if (obj instanceof Message)
            {
                System.out.println(" ***************messageReceived   Message   ->" + obj.toString()
                    + "  ********************");
            }
            if (obj instanceof ReplyBody)
            {
                System.out.println(" ***************messageReceived   ReplyBody   ->" + obj.toString()
                    + "  ********************");
            }
        }
        
        @Override
        public void messageSent(IoSession session, Object message)
            throws Exception
        {
            System.out.println(" ***************messageSent   ->" + message.toString() + "  ********************");
            
        }
    };
    
    public ReplyBody process(CIMSession newSession, SentBody message)
    {
        
        ReplyBody reply = new ReplyBody();
        // DefaultSessionManager sessionManager =
        // ((DefaultSessionManager)ContextHolder.getBean("defaultSessionManager"));
        try
        {
            
            String account = message.get("account");
            
            newSession.setAccount(account);
            newSession.setDeviceId(message.get("deviceId"));
            newSession.setGid(UUID.randomUUID().toString());
            newSession.setHost(InetAddress.getLocalHost().getHostAddress());
            newSession.setChannel(message.get("channel"));
            newSession.setDeviceModel(message.get("device"));
            /**
             * 由于客户端断线服务端可能会无法获知的情况，客户端重连时，需要关闭旧的连接
             */
            CIMSession oldSession = defaultSessionManager.getSession(account);
            if (oldSession != null)
            {
                
                // 如果是账号已经在另一台终端登录。则让另一个终端下线
                if ((oldSession.getDeviceId() != null && !oldSession.getDeviceId().equals(newSession.getDeviceId()) || !oldSession.equals(newSession)))
                {
                    
                    oldSession.removeAttribute(CIMConstant.SESSION_KEY);
                    Message msg = new Message();
                    msg.setType(CIMConstant.MessageType.TYPE_999);// 强行下线消息类型
                    msg.setReceiver(account);
                    
                    // TODO
                    if (!oldSession.isLocalhost())
                    {
                        
                        /*
                         * 判断当前session是否连接于本台服务器，如不是发往目标服务器处理 MessageDispatcher.execute(msg, oldSession.getHost());
                         */
                    }
                    else
                    {
                        oldSession.write(msg);
                        oldSession.close(true);
                        oldSession = null;
                    }
                    oldSession = null;
                }
                
            }
            if (oldSession == null)
            {
                // 第一次设置心跳时间为登录时间
                newSession.setBindTime(System.currentTimeMillis());
                newSession.setHeartbeat(System.currentTimeMillis());
                
                defaultSessionManager.addSession(account, newSession);
                
            }
            
            reply.setCode(CIMConstant.ReturnCode.CODE_200);
            
        }
        catch (Exception e)
        {
            reply.setCode(CIMConstant.ReturnCode.CODE_500);
            e.printStackTrace();
        }
        System.out.println("bind :account:" + message.get("account") + "-----------------------------"
            + reply.getCode());
        return reply;
    }
}
