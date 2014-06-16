package com.sklay.controller;

import java.util.HashMap;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.chat.push.SystemMessagePusher;
//import com.google.gson.Gson;
//import com.opensymphony.xwork2.ActionSupport;
//import com.opensymphony.xwork2.ModelDriven;

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
     * ����http�����ȡ�� struts2 ��ģ���� ���� http ���� sender=xiaomao&receiver=xiaogou struts�Զ��Ὣ�����ֵ
     * ����getModel()���صĶ���Ķ�Ӧ�����У���xiaomao�����message.sender����,xiaogou�����message.receiver����
     * ʡȥ��request.getParameter("sender")��ʽ��ȡ��������������getModel()���صĶ����в����ڣ�����Ҫ��request.getParameter()��ȡ �������*Action.java��
     * ͬ�?������ͳһ˵��!
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
            
            // ��ͻ��� ������Ϣ
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
     * �ļ��ɿͻ��˷������� OSS �洢
     * 
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
