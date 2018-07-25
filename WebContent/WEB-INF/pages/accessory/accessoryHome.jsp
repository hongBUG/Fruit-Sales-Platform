<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>附属品管理</title>
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
		
		.addAccessory Mask{
			width: 100%;
			height: 100%;
			position: absolute;
			background: rgba(0, 0, 0, .3);
			display: none;
		}
	</style>
</head>
<body >
	<div class="addAccessoryMask">
		<div class="c">
			<div style="background-color:#173e65; height:20px; color:#fff; font-size:12px; padding-left:7px;" >
				添加附属品信息<font style="float:right; padding-right:10px;" onclick="showAddAccessory('false')">X</font>
			</div>
			<form id="addAccessoryForm" action="add.action" method="post" onsubmit="checkAddAccessory()">
			名称：<input type="text" id="addAccessoryName" name="name" style="width:120px" /><br>
			价格：<input type="text" id="addAccessoryPrice" name="price" style="width:120px" /><br>
			<input type="hidden" id="aFruitId" name="fruitId" value="${fruitId }" />
			<input type="submit" value="添加" style="background-color: #173e65; color:#fff; width:70px;" />
			</form>
		</div>
	</div>
	<button onclick="showAddAccessory('true')" style="background-color:#173e65; color:#fff; width:70px;">添加</button>
	<button onclick="deleteAccessory()" style="background-color:#173e65; color:#fff; width:70px;">删除</button>

	<c:if test="${list != null }"> 
		<table style="margin-top: 10px; width: 400px; text-align: center;" border=1>
			<tr>
				<td>
					<input type="checkbox" onclick="checkAll(this)" />
				</td>
				<td>名称</td>
				<td>价格</td>
				<td>创建日期</td>
			</tr>
			<c:forEach items="${list }" var="item" varStatus="status">
				<tr>
					<td>
						<input type="checkbox" name="arrays" value="${item.accessoryId }"/>
					</td>
					<td>${item.name }</td>
					<td>${item.price }</td>
					<td>${item.createTime }</td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
	<c:if test="${list == null }">
		<b>搜索结果为空！</b>
	</c:if>

<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.4.4.min.js" />
<script type="text/javascript">
	
	function showAddAccessory(flag) {
		if (flag == "true") {
			$(".addAccessoryMask").css("display", "block");
		}else {
			$(".addAccessoryMask").css("display", "none");
		}
	}
	
	// 全选
	function checkAll(obj) {
		var isCheck = obj.cheched;
		var checkList=$("name='arrays'"); //获取所有check选项
		for (var i = 0; i < checkList.length; i++) {
			checkList[i].checked = isCheck;
		}
	}
	
	function deleteAccessory() {
		var myArray = new Array();
		var len = 0;
		var fruitId = $("#aFruitId").val();
		var arrays = $("name='arrays'");
		for (var i = 0; i < arrays.length; i++) {
			if (arrays[i].checked) {
				myArray[len++] = arrays[i].val();
			}
		}
		$.ajax({
			type: 'post',
			url: '${pageContext.request.contextPath}/accessory/deleteList.action',
			traditional: true,  // 使用传统的方式来序列化数据，防止深度序列化
			success: function(data) {  // 成功后刷新页面
				alert("删除成功");
				location.reload();
			}
		})
	}
</script>
</body>
</html>