package com.sklay.core.chat.nio.session.impl;

import java.util.Collection;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.session.CIMSession;
import com.sklay.core.chat.nio.session.SessionManager;

/**
 * 自带默认 session管理实现， 各位可以自行实现 AbstractSessionManager接口来实现自己的 session管理
 * 
 * @author 1988fuyu@163.com
 * @param <T>
 */
// @Component
public class DefaultSessionManager implements SessionManager
{
    
    private String cacheKey;
    
    private String cacheSessionKey;
    
    private boolean kickoutAfter = false; // 踢出之前登录的/之后登录的用户 默认踢出之前登录的用户
    
    private int maxSession = 1; // 同一个帐号最大会话数 默认1
    
    private Cache<String, Deque<String>> cache;
    
    private HashMap<String, CIMSession> sessionManagerCache = Maps.newHashMap();
    
    // private static HashMap<String, CIMSession> sessions = new HashMap<String, CIMSession>();
    
    private static final AtomicInteger connectionsCounter = new AtomicInteger(0);
    
    /**
     *  
     */
    public void addSession(String account, CIMSession session)
    {
        if (session != null)
        {
            String sessionId = session.getGid();
            sessionManagerCache.put(sessionId, session);
            
            session.setAttribute(CIMConstant.SESSION_KEY, account);
            // 同步控制
            Deque<String> deque = cache.get(account);
            if (deque == null)
            {
                deque = new LinkedList<String>();
                cache.put(account, deque);
            }
            
            if (!deque.contains(sessionId) && session.getAttribute("kickout") == null)
            {
                deque.push(sessionId);
            }
            
            while (deque.size() > maxSession)
            {
                String kickoutSessionId = null;
                if (kickoutAfter)
                {
                    kickoutSessionId = deque.removeFirst();
                }
                else
                {
                    kickoutSessionId = deque.removeLast();
                }
                try
                {
                    CIMSession kickoutSession = sessionManagerCache.get(kickoutSessionId);
                    
                    if (kickoutSession != null)
                    {
                        kickoutSession.setAttribute("kickout", true);
                    }
                }
                catch (Exception e)
                {
                    // ignore exception
                }
            }
            if (session.getAttribute("kickout") != null)
            {
                sessionManagerCache.remove(session.getGid());
                
                session.removeAttribute(CIMConstant.SESSION_KEY);
                Message msg = new Message();
                msg.setType(CIMConstant.MessageType.TYPE_999);// 强行下线消息类型
                msg.setReceiver(account);
                
                session.write(msg);
                session.close(true);
                session = null;
                
            }
            // sessions.put(account, session);
            connectionsCounter.incrementAndGet();
        }
        
    }
    
    public List<CIMSession> getSession(String account)
    {
        List<CIMSession> sessions = null;
        Deque<String> deques = cache.get(account);
        
        if (null != deques && deques.size() > 0)
        {
            sessions = Lists.newArrayList();
            for (Iterator<String> itr = deques.iterator(); itr.hasNext();)
            {
                String gid = itr.next();
                
                sessions.add(sessionManagerCache.get(gid));
            }
        }
        
        return sessions;
    }
    
    public Collection<CIMSession> getSessions()
    {
        return sessionManagerCache.values();
    }
    
    public void removeSession(CIMSession session)
    {
        Deque<String> deques = cache.get(session.getAccount());
        String currentGid = session.getGid();
        if (null != deques && deques.size() > 0)
        {
            for (Iterator<String> itr = deques.iterator(); itr.hasNext();)
            {
                String gid = itr.next();
                if (gid.equals(currentGid))
                    cache.remove(gid);
            }
        }
        sessionManagerCache.remove(session.getGid());
    }
    
    /**
     * 所有登入方式全部登出
     */
    public void removeSession(String account)
    {
        Deque<String> deques = cache.get(account);
        
        if (null != deques && deques.size() > 0)
        {
            for (Iterator<String> itr = deques.iterator(); itr.hasNext();)
            {
                String gid = itr.next();
                
                sessionManagerCache.remove(gid);
            }
            cache.remove(account);
        }
    }
    
    // public boolean containsCIMSession(CIMSession ios)
    // {
    // return sessions.containsKey(ios.getAttribute(CIMConstant.SESSION_KEY)) || sessions.containsValue(ios);
    // }
    
    // TODO
    public String getAccount(CIMSession ios)
    {
        if (ios.getAttribute(CIMConstant.SESSION_KEY) == null)
        {
            for (String key : sessionManagerCache.keySet())
            {
                if (sessionManagerCache.get(key).equals(ios)
                    || sessionManagerCache.get(key).getNid().equals(ios.getNid()))
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
        // CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(entityClass);
        // Root entityRoot = criteriaQuery.from(entityClass);
        // Predicate[] predicates = new Predicate[propValueMap.size()];
        // int i = 0;
        // for (Iterator<String> propNameIt = propValueMap.keySet().iterator(); propNameIt.hasNext(); i++)
        // {
        // String propName = propNameIt.next();
        // predicates[i] = criteriaBuilder.equal(entityRoot.get(propName), propValueMap.get(propName));
        // }
        // criteriaQuery.select(entityRoot);
        // criteriaQuery.where(predicates);
        // Query query = entityManager.createQuery(criteriaQuery);
        // query.setHint(QueryHints.CACHEABLE, true);
        // List results = query.getResultList();
        // if (CollectionUtils.isEmpty(results))
        // {
        // return null;s
        // }
        // else
        // {
        // return results.get(0);
        // }
        return null;
    }
    
    public void setCacheManager(CacheManager cacheManager)
    {
        this.cache = cacheManager.getCache(cacheKey);
    }
    
    /**
     * @param cacheKey the cacheKey to set
     */
    public void setCacheKey(String cacheKey)
    {
        this.cacheKey = cacheKey;
    }
    
    /**
     * @param kickoutAfter the kickoutAfter to set
     */
    public void setKickoutAfter(boolean kickoutAfter)
    {
        this.kickoutAfter = kickoutAfter;
    }
    
    /**
     * @param maxSession the maxSession to set
     */
    public void setMaxSession(int maxSession)
    {
        this.maxSession = maxSession;
    }
    
    /**
     * @param cacheSessionKey the cacheSessionKey to set
     */
    public void setCacheSessionKey(String cacheSessionKey)
    {
        this.cacheSessionKey = cacheSessionKey;
    }
    
    @Override
    public boolean containsCIMSession(CIMSession ios)
    {
        // TODO Auto-generated method stub
        return false;
    }
    
}
