 
package com.sklay.core.chat.nio.handle;

import org.apache.log4j.Logger;
import org.apache.mina.core.session.IoSession;

import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.handle.CIMRequestHandler;
import com.sklay.core.chat.nio.mutual.ReplyBody;
import com.sklay.core.chat.nio.mutual.SentBody;

/**
 *客户端心跳实现
 * 
 * @author
 */
public class HeartbeatHandler implements CIMRequestHandler {

	protected final Logger logger = Logger.getLogger(HeartbeatHandler.class);

	public ReplyBody process(IoSession session, SentBody message) {

		logger.warn("heartbeat... from "+session.getRemoteAddress().toString());
		ReplyBody reply = new ReplyBody();
		reply.setKey(CIMConstant.RequestKey.CLIENT_HEARTBEAT);
		reply.setCode(CIMConstant.ReturnCode.CODE_200);
		session.setAttribute("heartbeat", System.currentTimeMillis());
		 
		return reply;
	}
	
 
	
}