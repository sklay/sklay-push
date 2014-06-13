<%@page import="org.apache.commons.collections.CollectionUtils"%>
<%@page import="com.sklay.chat.common.util.StringUtil"%>
<%@ page language="java" pageEncoding="utf-8"%>
<%@ page import="java.util.Collection"%>
<%@ page import="org.apache.mina.core.session.IoSession"%>
<%
    String path = request.getContextPath();
    String basePath =
        request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
    
    Collection<IoSession> sessionList = (Collection<IoSession>)request.getAttribute("sessionList");
    
    if(CollectionUtils.isEmpty(sessionList))
        return  ;
    
    for (IoSession ios : sessionList)
    {
%>
<tr id="<%=ios.getAttribute("account")%>">
	<td><%=ios.getAttribute("account")%></td>
	<td><%=ios.getAttribute("channel")%></td>
	<td><%=(System.currentTimeMillis() - Long.valueOf(ios.getAttribute("loginTime").toString())) / 1000%>秒
	</td>
	<td>
		<%
		    if (ios.getAttribute("heartbeat") != null)
		        {
		%> <%=StringUtil.transformDateTime(Long.valueOf(ios.getAttribute("heartbeat").toString()))%>
		<%
		    }
		%>
	</td>
	<td>
		<div class="btn-group btn-group-xs">
			<button type="button" class="btn btn-primary" style="padding: 5px;"
				onclick="showMessageDialog('<%=ios.getAttribute("account")%>')">发送消息</button>
			<button type="button" class="btn btn-danger" style="padding: 5px;"
				onclick="doOffLine('<%=ios.getAttribute("account")%>')">强制下线</button>
		</div>
	</td>
</tr>
<%
    }
%>

