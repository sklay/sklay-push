<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../include.jsp"%>
<%@page import="com.sklay.chat.common.util.StringUtil"%>
<%@ page import="java.util.Collection"%>
<%@ page import="org.apache.mina.core.session.IoSession"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="request"/>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>CIM管理系统</title>
		<link charset="utf-8" rel="stylesheet" href="${ctx }/static/css/webbase.css" />
		<link charset="utf-8" rel="stylesheet" href="${ctx }/static/css/main-layout.css" />
		<link charset="utf-8" rel="stylesheet" href="${ctx }/static/css/base-ui.css" />
		<link charset="utf-8" rel="stylesheet" href="${ctx }/static/css/table.css" />
		<link charset="utf-8" rel="stylesheet" 	href="${ctx }/static/bootstrap/css/bootstrap.min.css" />
		<link charset="utf-8" rel="stylesheet" href="${ctx }/static/css/dialog.css" />
		<script type="text/javascript" 	src="${ctx }/static/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${ctx }/static/bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript" src="${ctx }/static/js/framework.js"></script>
		<script>
		
		  function doOffLine(account)
		  {
		     var setting = {hint:"确定让这个用户强制下线吗?",
		                    onConfirm:function(){
		                      $.post("${ctx }/admin/offline", {account:account},
							  function(data){
							      showSTip("下线成功");
					              $('#'+account).fadeOut().fadeIn().fadeOut();
					              doHideConfirm();
						      });
		                     
		                    }};
		     
		     doShowConfirm(setting);
		  }
		  
		  function showMessageDialog(account)
			{
			   doShowDialog("messageDialog");
			   $('#account').val(account);
			   
			}
		 function doSendMessage()
		  {
		    var message = $('#message').val();
		    var account = $('#account').val();
		    if($.trim(message)=='')
		    {
		       return;
		    }
		    showProcess('正在发送，请稍后......');
		    $.post("${ctx }/cgi/send.action", {content:message,type:2,sender:'system',receiver:account},
			   function(data){
			   
			      hideProcess();
			      showSTip("发送成功");
			      doHideDialog("messageDialog");
			      
		     });
		  }
		  
		</script>
	</head>
	<body class="web-app ui-selectable">

	 <tiles:insertAttribute name="header" ignore="true" />
	 <tiles:insertAttribute name="nav" ignore="true" />
		<div id="mainWrapper">
			<div class="panel panel-default">
				<div class="panel-heading">
					在线用户
				</div>
				<div class="panel-body" style="padding: 5px;">
					<form action="${ctx }/admin/manage" method="post" id="searchForm" style="padding: 0px;">
						<input type="hidden" name="currentPage" id="currentPage" />
						<table style="margin: 5px;width: 100%" class="utable">

							<thead>
								<tr class="tableHeader">
									<th width="20%">账号</th>
									<th width="20%">终端</th>
									<th width="20%">在线时长</th>
									<th width="20%">心跳时间</th>
									<th width="40%">操作</th>
								</tr>
								 
							</thead>
							<tbody id="checkPlanList">
						       <tiles:insertAttribute name="content" ignore="true" />
							</tbody>
							<tfoot>
								 
							</tfoot>
						</table>
					</form>

				</div>
			</div>
			
			
		<div class="panel panel-primary gdialog" id="messageDialog" style="display: none;width: 420px;position: absolute;z-index: 1001;">
		  <div class="panel-heading">发送消息
		  <a class="close"  onclick="doHideDialog('messageDialog'),$('#messageDialog').css('z-index',1000);">&times;</a>
		  </div>
		  <div class="panel-body">
		   <form role="form">
		      <div class="form-groupBuy">
			    <label for="Amobile">
					接收者账号:
				</label>
				<input type="text" class="form-control" id="account" name="account"
					  style="  width: 100%;font-size: 20px;font-weight: bold;" disabled="disabled" />
			  </div>
			  <div class="form-groupBuy" style="margin-top: 20px;">
			    <label for="exampleInputFile" style="padding-left: 7px;">消 息 内 容:</label>
			    <textarea rows="10" style="width: 100%;height: 120px;" id="message" name="message"  class="form-control"></textarea>
			  </div>
			   <div class="form-groupBuy" style="margin-top: 20px;">
			      <center>
				     <button type="button" style="width: 150px;"  class="btn btn-success btn-lg" onclick="doSendMessage()">发 送</button>
			      </center>
			   </div>
			   
			</form>
		  </div>
		</div>

		<script>
		       $('#sessionMenu').addClass('current');
		       
		</script>
	</body>
</html>
