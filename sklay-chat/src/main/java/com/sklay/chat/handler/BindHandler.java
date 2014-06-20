package com.sklay.chat.handler;

import java.net.InetAddress;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.apache.commons.collections.CollectionUtils;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionTemplate;

import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;
import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

/**
 * 绑定账号到服务端实现
 * 
 * @author
 * @param <T>
 */
public class BindHandler<T> implements CIMRequestHandler
{
    protected final Logger logger = Logger.getLogger(BindHandler.class);
    
    private DefaultSessionManager sessionManager;
    
    private Class<T> entityClass;
    
    private String usernameField;
    
    private String passwordField;
    
    private String queryMethod;
    
    private String addMethod;
    
    private SqlSessionTemplate sessionTemplate;
    
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
            List<CIMSession> oldSessions = sessionManager.getSession(account);
            
            if (CollectionUtils.isNotEmpty(oldSessions))
            {
                
                for (CIMSession oldSession : oldSessions)
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
                
            }
            else
            {
                // 第一次设置心跳时间为登录时间
                newSession.setBindTime(System.currentTimeMillis());
                newSession.setHeartbeat(System.currentTimeMillis());
                
                sessionManager.addSession(account, newSession);
            }
            reply.setCode(CIMConstant.ReturnCode.CODE_200);
        }
        catch (Exception e)
        {
            reply.setCode(CIMConstant.ReturnCode.CODE_500);
            e.printStackTrace();
        }
        logger.debug("bind :account:" + message.get("account") + "-----------------------------" + reply.getCode());
        
        return reply;
    }
    
    public void setUsernameField(String usernameField)
    {
        this.usernameField = usernameField;
    }
    
    public void setPasswordField(String passwordField)
    {
        this.passwordField = passwordField;
    }
    
    public void setEntityClass(Class<T> entityClass)
    {
        this.entityClass = entityClass;
    }
    
    /**
     * @param sessionManager the sessionManager to set
     */
    public void setSessionManager(DefaultSessionManager sessionManager)
    {
        this.sessionManager = sessionManager;
    }
    
    /**
     * @param sessionTemplate the sessionTemplate to set
     */
    public void setSessionTemplate(SqlSessionTemplate sessionTemplate)
    {
        this.sessionTemplate = sessionTemplate;
    }
    
    /**
     * @param queryMethod the queryMethod to set
     */
    public void setQueryMethod(String queryMethod)
    {
        this.queryMethod = queryMethod;
    }
    
    /**
     * @param addMethod the addMethod to set
     */
    public void setAddMethod(String addMethod)
    {
        this.addMethod = addMethod;
    }
}