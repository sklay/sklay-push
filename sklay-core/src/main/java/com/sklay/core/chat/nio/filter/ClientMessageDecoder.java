package com.sklay.core.chat.nio.filter;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import com.alibaba.fastjson.JSONObject;
import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ServerData;

/**
 * 客户端消息解码
 * 
 * @author 3979434@qq.com
 * 
 */
public class ClientMessageDecoder extends CumulativeProtocolDecoder
{
    private IoBuffer buff = IoBuffer.allocate(320).setAutoExpand(true);
    
    @Override
    public boolean doDecode(IoSession iosession, IoBuffer iobuffer, ProtocolDecoderOutput out)
        throws Exception
    {
        boolean complete = false;
        
        while (iobuffer.hasRemaining())
        {
            byte b = iobuffer.get();
            /**
             * CIMConstant.MESSAGE_SEPARATE 为消息界限 当一次收到多个消息时，以此分隔解析多个消息
             */
            if (b == CIMConstant.MESSAGE_SEPARATE)
            {
                
                complete = true;
                break;
            }
            else
            {
                buff.put(b);
            }
        }
        
        if (complete)
        {
            buff.flip();
            byte[] bytes = new byte[buff.limit()];
            buff.get(bytes);
            String message = new String(bytes, "UTF-8");
            buff.clear();
            System.out.println("ClientMessageDecoder:" + message);
            
            Object msg = mappingMessageObject(message);
            
            System.out.println("ClientMessageDecoder Object msg  :" + msg);
            
            out.write(msg);
        }
        
        return complete;
    }
    
    private Object mappingMessageObject(String message)
        throws Exception
    {
        JSONObject parse = JSONObject.parseObject(message);
        
        if (parse.containsKey("key"))
        {
            
            return JSONObject.parseObject(message, ServerData.class);
        }
        
        if (parse.containsKey("receiver"))
        {
            return JSONObject.parseObject(message, Message.class);
        }
        return JSONObject.parse(message);
        
        // DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        // DocumentBuilder builder = factory.newDocumentBuilder();
        // Document doc = (Document)builder.parse(new ByteArrayInputStream(message.toString().getBytes("UTF-8")));
        //
        // String name = doc.getDocumentElement().getTagName();
        // if (name.equals("reply"))
        // {
        // ReplyBody reply = new ReplyBody();
        // reply.setKey(doc.getElementsByTagName("key").item(0).getTextContent());
        // reply.setCode(doc.getElementsByTagName("code").item(0).getTextContent());
        // NodeList items = doc.getElementsByTagName("data").item(0).getChildNodes();
        // for (int i = 0; i < items.getLength(); i++)
        // {
        // Node node = items.item(i);
        // reply.getData().put(node.getNodeName(), node.getTextContent());
        // }
        // return reply;
        // }
        // if (name.equals("message"))
        // {
        //
        // Message body = new Message();
        // body.setType(doc.getElementsByTagName("type").item(0).getTextContent());
        // body.setContent(doc.getElementsByTagName("content").item(0).getTextContent());
        // body.setFile(doc.getElementsByTagName("file").item(0).getTextContent());
        // body.setFileType(doc.getElementsByTagName("fileType").item(0).getTextContent());
        // body.setTitle(doc.getElementsByTagName("title").item(0).getTextContent());
        // body.setSender(doc.getElementsByTagName("sender").item(0).getTextContent());
        // body.setReceiver(doc.getElementsByTagName("receiver").item(0).getTextContent());
        // body.setFormat(doc.getElementsByTagName("format").item(0).getTextContent());
        // body.setMid(doc.getElementsByTagName("mid").item(0).getTextContent());
        // body.setTimestamp(Long.valueOf(doc.getElementsByTagName("timestamp").item(0).getTextContent()));
        //
        // return body;
        // }
        //
        // return null;
    }
    
}
