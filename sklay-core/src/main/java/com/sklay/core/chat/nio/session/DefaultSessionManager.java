package com.sklay.core.chat.nio.session;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.sklay.core.chat.nio.constant.CIMConstant;

/**
 * 自带默认 session管理实现， 各位可以自行实现 AbstractSessionManager接口来实现自己的 session管理
 * 
 * @author 1988fuyu@163.com
 * @param <T>
 */
// @Component
public class DefaultSessionManager<T> implements SessionManager
{
    private Class<T> entityClass;
    
    private String userPKField = "id";
    
    private String usernameField;
    
    private String passwordField;
    
    private static HashMap<String, CIMSession> sessions = new HashMap<String, CIMSession>();
    
    private static final AtomicInteger connectionsCounter = new AtomicInteger(0);
    
    /**
     *  
     */
    public void addSession(String account, CIMSession session)
    {
        if (session != null)
        {
            session.setAttribute(CIMConstant.SESSION_KEY, account);
            sessions.put(account, session);
            connectionsCounter.incrementAndGet();
        }
        
    }
    
    public CIMSession getSession(String account)
    {
        
        return sessions.get(account);
    }
    
    public Collection<CIMSession> getSessions()
    {
        return sessions.values();
    }
    
    public void removeSession(CIMSession session)
    {
        
        sessions.remove(session.getAttribute(CIMConstant.SESSION_KEY));
    }
    
    public void removeSession(String account)
    {
        
        sessions.remove(account);
        
    }
    
    public boolean containsCIMSession(CIMSession ios)
    {
        return sessions.containsKey(ios.getAttribute(CIMConstant.SESSION_KEY)) || sessions.containsValue(ios);
    }
    
    // TODO
    public String getAccount(CIMSession ios)
    {
        if (ios.getAttribute(CIMConstant.SESSION_KEY) == null)
        {
            for (String key : sessions.keySet())
            {
                if (sessions.get(key).equals(ios) || sessions.get(key).getNid().equals(ios.getNid()))
                {
                    return key;
                }
            }
        }
        else
        {
            return ios.getAttribute(CIMConstant.SESSION_KEY).toString();
        }
        
        return null;
    }
    
    private Object getEntity(Map<String, ?> propValueMap)
    {
        CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        Root entityRoot = criteriaQuery.from(entityClass);
        Predicate[] predicates = new Predicate[propValueMap.size()];
        int i = 0;
        for (Iterator<String> propNameIt = propValueMap.keySet().iterator(); propNameIt.hasNext(); i++)
        {
            String propName = propNameIt.next();
            predicates[i] = criteriaBuilder.equal(entityRoot.get(propName), propValueMap.get(propName));
        }
        criteriaQuery.select(entityRoot);
        criteriaQuery.where(predicates);
        Query query = entityManager.createQuery(criteriaQuery);
        query.setHint(QueryHints.CACHEABLE, true);
        List results = query.getResultList();
        if (CollectionUtils.isEmpty(results))
        {
            return null;
        }
        else
        {
            return results.get(0);
        }
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
}
