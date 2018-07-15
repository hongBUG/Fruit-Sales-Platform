<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>login</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/css/regcss.css" type="text/css" rel="stylesheet"/>
</head>
<body>
	<div id="content">
		<div id="form">
			<h1>User Login</h1>
			<form action="user/login.action" method="post" id="myform" onsubmit="return validate()">
				<fieldset>
					<legend>User Login</legend>
					<table style="width:50%">
						<tr>
							<c:if test="${errorMsg != null }">
								<td><font color="red">${errorMsg }</font></td>
							</c:if>
							<c:if test="${noticeMsg != null }">
								<td><font color="green">${noticeMsg }</font></td>
							</c:if>
						</tr>
						<tr>
							<td>username</td>
							<td>
								<input type="text" id="username" name="username" style="width:190px; height:26px; margin-left:39px"/> 
							</td>
						</tr>
						<tr>
							<td>password</td>
							<td>
								<input type="password" id="password" name="password" style="width:190px; height:26px; margin-left:39px; margin-top: 8px;"/>
							</td>
						</tr>
						<tr>
							<td	colspan="2" class="command">
								<input type="submit" value="login" />
								<a href="toRegister.action" >注册</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>

	<script type="text/javascript">
		function validate() {
			if (document.getElementById("username").value=="") {
				alert("用户名不能为空");
				document.getElementById("username").focus();
				return false;
			} else if (document.getElementById("password").value=="") {
				alert("密码不能为空");
				document.getElementById("password").focus();
				return false;
			}
			
			return true;
		}
	</script>
</body>
</html>