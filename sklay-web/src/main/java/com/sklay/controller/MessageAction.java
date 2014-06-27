package com.sklay.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sklay.chat.push.impl.SystemMessagePusher;
import com.sklay.core.chat.nio.mutual.Message;

/**
 * 
 * @author 1988fuyu@163.com
 */
@Controller
@RequestMapping("/cgi")
public class MessageAction
{
    
    @Resource
    SystemMessagePusher systemMessagePusher;
    
    /**
     * 关于http参数获取，  struts2  的模型驱动  比如 http 参数 sender=xiaomao&receiver=xiaogou
     * struts自动会将参数的值 存入getModel()返回的对象的对应属性中，即xiaomao会存入message.sender属性,xiaogou会存入message.receiver属性
     * 省去了request.getParameter("sender")方式获取参数，，如果参数名在getModel()返回的对象中不存在，则需要用request.getParameter()获取
     * 其他相关*Action.java中 同理，这里做统一说明!
     */
    @RequestMapping("/send")
    @ResponseBody
    public HashMap<String, Object> send(Message message)
        throws Exception
    {
        
        HashMap<String, Object> datamap = new HashMap<String, Object>();
        HashMap<String, String> data = new HashMap<String, String>();
        // ServletActionContext.getResponse().setContentType("text/json;charset=UTF-8");
        datamap.put("code", 200);
        
        try
        {
            
            checkParams(message);
            
          //向客户端 发送消息
            systemMessagePusher.pushMessageToUser(message);
            
            data.put("id", message.getMid());
            data.put("createTime", String.valueOf(message.getTimestamp()));
            datamap.put("data", data);
        }
        catch (Exception e)
        {
            
            datamap.put("code", 500);
            e.printStackTrace();
        }
        
        // ServletActionContext.getResponse().getWriter().print(new Gson().toJson(datamap));
        return datamap;
    }
    
    /**
     * 文件由客户端发往阿里云 OSS 存储
     * @param messageServiceImpl
     */
    /*
     * private void fileHandler(Message mo, HttpServletRequest request) throws IOException { if(request instanceof
     * MultiPartRequestWrapper){ MultiPartRequestWrapper pr = (MultiPartRequestWrapper) request;
     * if(pr.getFiles("file")!=null) { File file = pr.getFiles("file")[0];
     * 
     * String fileType = request.getParameter("fileType"); String dir = dirMap.get(fileType);
     * if(StringUtils.isEmpty(dir)) { throw new IllegalArgumentException("fileType:" +fileType+" δ����" );
     * 
     * } String path = request.getSession().getServletContext().getRealPath(dir); String
     * uuid=UUID.randomUUID().toString().replaceAll("-", ""); File des = new File(path+"/"+uuid);
     * FileUtil.copyFile(file, des); mo.setFile(dir+"/"+uuid); mo.setFileType(fileType); } }
     * 
     * }
     */
    
    private void checkParams(Message message)
        throws ServletRequestBindingException
    {
        if (null == message)
        {
            throw new IllegalArgumentException("message ����Ϊ��!");
            
        }
        
        if (StringUtils.isEmpty(message.getReceiver()))
        {
            throw new IllegalArgumentException("receiver ����Ϊ��!");
            
        }
    }
    
}
