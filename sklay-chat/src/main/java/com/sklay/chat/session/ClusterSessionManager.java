package com.sklay.chat.session;

import java.util.Collection;

import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.SessionManager;

public class ClusterSessionManager implements SessionManager
{
    
    // private static HashMap<String,IoSession> sessions =new HashMap<String,IoSession>();
    
    /**
       *  
       */
    public void addSession(String account, CIMSession session)
    {
        
        /**
         * 下面 将session 存入数据库
         */
        
    }
    
    public CIMSession getSession(String account)
    {
        
        // 这里查询数据库
        /*
         * CIMSession session = database.getSession(account); session.setIoSession(((NioSocketAcceptor)
         * ContextHolder.getBean("serverAcceptor")).getManagedSessions().get(session.getNid())); return session;
         */
        return null;
    }
    
    public Collection<CIMSession> getSessions()
    {
        /*
         * //这里查询数据库 return database.getSessions();
         */
        return null;
    }
    
    public void removeSession(CIMSession session)
    {
        
        // database.removeSession(session.getAttribute(CIMConstant.SESSION_KEY));*/
    }
    
    public void removeSession(String account)
    {
        
        // database.removeSession(account);*/
        
    }
    
    public boolean containsCIMSession(CIMSession ios)
    {
        // return database.containsCIMSession(session.getAccount());
        
        return false;
    }
    
    public String getAccount(CIMSession ios)
    {
        return ios.getAccount();
    }
    
}
