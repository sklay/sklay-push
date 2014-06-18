package com.test.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.charset.Charset;
import org.apache.mina.core.future.ConnectFuture;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.filter.logging.LoggingFilter;
import org.apache.mina.transport.socket.nio.NioSocketConnector;

/**
 * 客户端主程序
 * 
 * @author Lancelot He
 * @version $Rev: $, Nov 9, 2009 2:52:43 PM
 */
public class MinaClient
{
    public static void main(String[] args)
        throws IOException
    {
        String IP = "127.0.0.1";
        int PORT = 8901;
        // 创建客户端连接器.
        NioSocketConnector connector = new NioSocketConnector();
        // 设置日志记录器
        connector.getFilterChain().addLast("logger", new LoggingFilter());
        // 设置编码过滤器
        connector.getFilterChain().addLast("codec",
            new ProtocolCodecFilter(new TextLineCodecFactory(Charset.forName("UTF-8"))));
        // 设置连接超时检查时间
        connector.setConnectTimeoutCheckInterval(30);
        // 设置事件处理器
        connector.setHandler(new ClientHandler());
        // 建立连接
        ConnectFuture cf = connector.connect(new InetSocketAddress(IP, PORT));
        // 等待连接创建完成
        cf.awaitUninterruptibly();
        // 发送消息到服务端
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true)
        {
            String inString = bufferedReader.readLine();
            cf.getSession().write(inString);
            if (inString.equals("quit"))
            {
                break;
            }
        }
        // 等待连接断开
        // cf.getSession().getCloseFuture().awaitUninterruptibly();
        // 释放连接
        connector.dispose();
    }
}
