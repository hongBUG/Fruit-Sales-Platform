<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="menuContent" style="background-color: #173E65; color: #ffffff; height: 100px; " >
	<h1 style="margin-left: 10px; margin-top: 10px;">水果网络销售哦平台</h1><br>
	<div style="margin-left: 10px;">
		<a href="${pageContext.request.contextPath }/commodities/list.action">货物管理</a> | 
		<a href="${pageContext.request.contextPath }/retailer/list.action?status=-1">零售商管理</a> |   
		<a href="${pageContext.request.contextPath }/retailer/list.action?status=">购销合同管理</a> |   
		<a href="${pageContext.request.contextPath }/retailer/list.action?status=">用户设置</a>  
	</div>
	<div style="background-color: #cccccc;" >
		<span style="margin-left: 10px;" >欢迎您，${sessionScope.user.name }</span>
	</div>

</div> 