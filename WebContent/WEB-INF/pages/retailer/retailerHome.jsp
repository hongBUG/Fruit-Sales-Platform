<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>零售商管理</title>
	<style>
		*{
			margin: 0;
			padding: 0;
		}
		#menuContent a {
			text-decoration: none;
			color: #ffffff;
		}
		.c {
			border-style: solid;
			width: 200px;
			height: 130px;
			margin: 4px 23px 0 23px;
			border-radius: 5px;
			display: block;
			background: #fff;
			margin: 10% auto;
		}
		
		.mask .addMask{
			width: 100%;
			height: 100%;
			position: absolute;
			background: rgba(0, 0, 0, .3);
			display: none;
		}
	</style>
</head>
<body onload="init()">
	<%@ include file="../menu.jsp" %>
	<div class="addMask">
		<div class="c">
			添加信息：<font style="float:right; padding-right: 10px;" onclick="showAddMask('false')">X</font>
		</div>
		<form id="addForm" action="add.action" method="post" onsubmit="checkAddRetailer()">
			姓名：<input type="text" id="addName" name="name" style="width:120px" /><br>
			手机：<input type="text" id="addTelephone" name="telephone" style="width:120px" /><br>
			地址：<input type="text" id="addAddress" name="address" style="width:120px" /><br>
			<input type="hidden" name="status" value="1" />
			<input type="submit" value="添加" style="background-color: #173e65; color:#fff; width:70px;" />
		</form>
	</div>
	<div class="mask">
		<div class="c">
			<div style="background-color: #173e65; height: 20px; color: #fff; font-siz: 12px; padding-left: 7px;">
				修改信息<font style="float: right; padding-right: 10px;" onclick="cancelEdit()">x</font>
			</div>
			<form id="editForm" action="edit.action" method="post">
				姓名：<input type="text" id="editName" name="name" style="width: 120px" /> <br>
				手机：<input type="text" id="editTelephone" name="telephone" style="width: 120px" /> <br>
				地址：<input type="text" id="editAddress" name="address" style="width: 120px" /> <br>
				状态：<select id="eStatus" onchange="changeEditStatus()">
					<option value="1">启用</option>
					<option value="0">停用</option>
				</select>
				<input type="hidden" name="retailerId" id="retailerId" />
				<input type="hidden" name="status" id="editeStatus" />
				<input type="hidden" name="startPage" id="eStartPage" />
				<input type="hidden" name="currentPage" id="eCurrentPage" />
				<input type="hidden" name="pageSize" id="ePageSize" />
				<input type="submit" value="提交" style="background-color:#173e65; color:#ffffff; width:70px"; />
			</form>
		</div>
	</div>
	<form id="listForm" action="toList.action" method="post" >
		姓名：<input type="text" name="name" style="width: 120px" />
		手机：<input type="text" name="telephone" style="width: 120px" />
		地址：<input type="text" name="address" style="width: 120px" />
		<br/><br/>
		状态：<select id="indexStatus" onchange="changeStatus()" >
		<option value="-1" selected="selected">全部</option>
		<option value="1" >启用</option>
		<option value="0" >停用</option>
		</select>
		<input type="hidden" name="status" id="status" value="1">
		创建日期：<input type="text" name="createTime" />
		<input type="submit" value="搜索" style="background-color:#173e65; color:#ffffff; width:70px;" /><br/>
		<!-- 显示错误信息 -->
		<c:if test="${errorMsg != null}">
			<font color="red">${errorMsg }</font><br/>
		</c:if>
		<input type="hidden" name="startPage" id="startPage" value="${startPage }" />
		<input type="hidden" name="pageSize" id="pageSize" value="${pageSize }" />
		<input type="hidden" name="currentPage" id="currentPage" value="${currentPage }" />
		<input type="hidden" name="countNumber" id="countNubmer" value="${countNubmer }" />
		<input type="hidden" name=sumPageNumber" id="sumPageNumber" value="${sumPageNumber }" />
	</form>
	<hr style="margin-top: 10px" />
	<button onclick="showAddMask('true')" style="background-color: #173e65; color:#fff; width:70px;">添加代理商</button>
	<c:if test="${list != null }"> 
		<table style="margin-top: 10px; width: 700px; text-align: center;" border=1>
			<tr>
				<td>序号</td>
				<td>姓名</td>
				<td>手机号</td>
				<td>地址</td>
				<td>状态</td>
				<td>创建日期</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${list }" var="item" varStatus="status">
				<tr>
					<td>${status.index+1 }</td>
					<td>${item.name }</td>
					<td>${item.telephone }</td>
					<td>${item.address }</td>
					<td>
						<c:if test="${item.status==1 }">
							<font color="bule">启用</font>
						</c:if>
						<c:if test="${item.status==0 }">
							<font color="red">停用</font>
						</c:if>
					</td>
					<td>${item.createTime }</td>
					<td>
						<a onclick="editRetailer('${item.retailerId}')">编辑</a> | 
						<a onclick="deleteRetailer('${item.retailerId}', '${item.name }')">删除</a>
						<form action="delete.action" id="deleteForm" method="post" >
							<input type="hidden" name="retailerId" di="dRetailerId" />
							<input type="hidden" name="startPage" di="dStartPage" />
							<input type="hidden" name="currentPage" di="dCurrentPage" />
							<input type="hidden" name="pageSize" di="dPageSize" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${list == null }">
		<b>搜索结果为空！</b>
	</c:if>
	<div style="margin-top: 10px">
		<a onclick="toPrePage()">上一页</a><a onclick="toNextPage()">下一页</a>
		<button onclick="toLocationPage()">goto</button><input type="text" id="pageNumber" style="width: 50px"/>
		<div id="pageInfo"></div>
	</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js" />
<script type="text/javascript">
	function changeStatus() {
		var status = document.getElementById("indexStatus").value;
		document.getElementById("status").value = status;
	}
	
	function init() {
		var countNumber = document.getElementById("countNumber").value;
		var sumPage = document.getElementById("sumPageNumber").value;
		var currentPage = document.getElementById("currentPage").value;
		var info = "一共<font color='blue'>" + countNumber + "</font>条数据，" +
			"共<font color='blue'>" + sumPage + "</font>页，" +
			"当前第<font color='blue'>" + currentPage + "</font>一页";
		document.getElementById("pageInfo").innerHTML=info;
	}
	
	function toPrePage() {
		var currentPageObject = document.getElementById("currentPage");
		var currentPage = parseInt(currentPageObject.value);
		if (currentPage == 1) {
			alert("已是首页");
		} else {
			currentPageObject.value = currentPage - 1;
			var pageSize = parseInt(document.getElementById("pageSize").value);
			var startPageObject = document.getElementById("startPage");
			startPageObject.value = parseInt(startPageObject.value) - pageSize;
			document.getElementById("listForm").submit();
		}
	}
	
	function toNextPage() {
		var currentPageObject = document.getElementById("currentPage");
		var currentPage = parseInt(currentPageObject.value);
		var sumPage = parseInt(document.getElementById("sumPageNumber").value);
		if (currentPage >= sumPage) {
			alert("已是最后一页");
		} else {
			currentPageObject.value = currentPage + 1;
			var pageSize = parseInt(document.getElementById("pageSize").value);
			var startPageObject = document.getElementById("startPage");
			startPageObject.value = parseInt(startPageObject.value) + pageSize;
			document.getElementById("listForm").submit();
		}
	}
	
	function toLocationPage() {
		var currentPageObject = document.getElementById("currentPage");
		var currentPage = parseInt(currentPageObject.value);
		var sumPage = parseInt(document.getElementById("sumPageNumber").value);
		var pageNumberObject = document.getElementById("pageNumber");
		var pageNumber = pageNumberObject.value;
		if (pageNumber == null || pageNumber == "") {
			alert("请输入要跳转的页数");
			pageNumberObject.focus();
		}
		else {
			pageNumber = parseInt(pageNumber);
			if (pageNumber < 1 || pageNumber > sumPage) {
				aler("请输入合理的页数");
				pageNumberObject.focus();
			} else {
				currentPageObject.value = pageNumber;
				var pageSize = parseInt(document.getElementById("pageSize").value);
				var startPageObject = document.getElementById("startPage");
				startPageObject.value =  (pageNumber - 1 ) * pageSize ;
				document.getElementById("listForm").submit();
		}
	}
		
	function editRetailer(retailerId) {
		$.ajax({
			type: "post",
			url: "${pageContext.request.contextPath}/retailer/editRetailer.action",
			contentType: "application/json;charset=utf-8",
			data: {
				 id: retailerId// 数据格式是json串
			},
			success: function(data){
				$("#editName").val(data["name"]);vvvvvvvvvvv
				$("#editTelephone").val(data["telephone"]);
				$("#editAddress").val(data["address"]);
				$("#retailerId").val(date["retailerId"]);
				$("#editStatus").val(data["status"]);
				$("#eStatus").val(data["status"]);
				// 显示弹出框
				$(".mask").css("display", "block");
				// 引入分页信息至该form表单
				$("#eStartPage").val($("#startPage").val());
				$("#eCurrentPage").val($("#currentPage").val());
				$("#ePageSize").val($("#pageSize").val());
			},
			error: function(error) {
				aler("error: " + error.status);
			}
		});
	}
	
	function cancelEdit() {
		$(".mask").css("display", "none");	
	}
	
	function changeEditStatus() {
		var status = $("#editStatus").val();
		$("eStatus").val(status);
	}
	
	function deleteRetailer(id, name){
		if(window.confirm("确认删除用户 " + name + "?")) {
			$("#dRetailerId").val(id); // 向form中引入id
			// 引入分页信息
			$("#dStartPage").val($("#startPage"));
			$("#dCurrentPage").val($("#currentPage"));
			$("#dPageSize").val($("#pageSize"));
			$("#deleteForm").submit(); // 提交表单
		}
	}
	
	function showAddMask(flag) {
		if (flag == "true") {
			$(".addMask").css("display", "block");
		}else {
			$(".addMask").css("display", "none");
		}
	}
	
	function checkAddRetailer() {
		// 进行表单数据空校验
		 if ($("#addName").val() == null || $("#addName").val() == "") {
			 alert("用户名不能为空");
			 $("#addName").focus();
			 return false;
		 }
		 if ($("#addTelephone").val() == null || $("#addTelephone").val() == "") {
			 alert("手机号不能为空！");
			 $("#addTelephone").focus();
			 return false;
		 }
		 var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
		 if (!myreg.test($("#addTelephone").val())) {
			 aler("请输入有效的11位号码");
			 $("#addTelephoen").focus();
			 return false;
		 }
		 if ($("#addAddress").val() == null || $("#addAddress").val() == "") {
			 aler("请输入有效的11位号码");
			 $("#addTelephoen").focus();
			 return false;
		 }
		 return true;
	}
</script>
</body>
</html>