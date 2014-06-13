package com.sklay.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sklay.chat.push.SystemMessagePusher;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.session.DefaultSessionManager;

@Controller
@RequestMapping("/admin")
public class SessionAction
{
    
    @Resource
    DefaultSessionManager defaultSessionManager;
    
    @Resource
    SystemMessagePusher systemMessagePusher;
    
    @RequestMapping("/manage")
    public String list(final HttpServletRequest request)
    {
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
}
