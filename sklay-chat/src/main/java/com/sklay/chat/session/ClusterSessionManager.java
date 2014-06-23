package com.sklay.chat.session;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Component;

import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.SessionManager;

@Component
public class ClusterSessionManager implements SessionManager
{
    
    // private static HashMap<String,IoSession> sessions =new HashMap<String,IoSession>();
    
    @Resource
    private SqlSessionTemplate sessionTemplate;
    
    /**
     * 
     */
    public void addSession(String account, CIMSession session)
    {
        Object object = sessionTemplate.selectOne("com.sklay.dao.UserDAO.queryByUsername", account);
        System.out.println(object.toString());
        /**
         * 下面 将session 存入数据库
         */
        
    }
    
    public List<CIMSession> getSession(String account)
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
