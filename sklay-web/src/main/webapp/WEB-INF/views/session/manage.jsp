<%@page import="com.sklay.core.chat.nio.session.CIMSession"%>
<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.sklay.chat.common.util.StringUtil"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.Collection"%>
<%@ page import="org.apache.mina.core.session.IoSession"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    
    Collection<CIMSession> sessionList = (Collection<CIMSession>)request.getAttribute("sessionList");
    
    if(CollectionUtils.isEmpty(sessionList))
        return  ;
    
    for(CIMSession ios:sessionList)
    {
  
   %>
   	<tr id="<%=ios.getAccount()%>">
			<td>
				<%=ios.getAccount() %>
			</td>
			<td>
				<%=ios.getChannel() %>
			</td>
			<td>
				<%=ios.getDeviceId() %>
			</td>
			<td>
				<%=ios.getDeviceModel() %>
			</td>
			<td>
			    <%=(System.currentTimeMillis()-ios.getBindTime())/1000 %>秒
			</td>
			 
			<td>
				<div class="btn-group btn-group-xs">
				  <button type="button" class="btn btn-primary" style="padding: 5px;" onclick="showMessageDialog('<%=ios.getAccount() %>')">发送消息</button>
				  <button type="button" class="btn btn-danger"  style="padding: 5px;" onclick="doOffLine('<%=ios.getAccount()  %>')">强制下线</button>
				</div>
			</td>
		</tr>	
	<%} %>		

