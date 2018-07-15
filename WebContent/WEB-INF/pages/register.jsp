<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Register</title>
	<link href="${pageContext.request.contextPath }/css/regcss.css" type="text/css" rel="stylesheet">
</head>
<body>
	<div id="content">
		<div id="form">
			<h1>User Register</h1>
			<form actoin="user/register.action" method="post" id="myform" onsubmit="return validate()">
				<fieldset>
					<legend>User Register</legend>
					<table style="width:50%">
						<tr>
							<c:if test="${errorMsg != null }">
								<td><font color="red">${errorMsg }</font></td>
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
							<td>repassword</td>
							<td>
								<input type="password" id="repassword" name="repassword" style="width:190px; height:26px; margin-left:39px; margin-top: 8px;"/>
							</td>
						</tr>
						<tr>
							<td>name</td>
							<td>
								<input type="text" id="name" name="name" style="width:190px; height:26px; margin-left:39px; margin-top: 8px;"/>
							</td>
						</tr>
						<tr>
							<td>telphone</td>
							<td>
								<input type="text" id="telephone" name="telephone" style="width:190px; height:26px; margin-left:39px; margin-top: 8px;"/>
							</td>
						</tr>
						<tr>
							<td	colspan="2" class="command">
								<input type="submit" value="registe" />
								<a href="toLogin.action" >return to login</a>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
	</div>

<script type="text/javascript">
	function validate() {
		var username = document.getElementById("username");
		var password = document.getElementById("password");
		var repasswors = document.getElementById("repassword");
		var name = document.getElementById("name");
		var tel = document.getElementById("telephone");
		if (username.value == "") {
			alert("用户名不能为空");
			username.focus();
			return false;
		} else if (password.value == "") {
			alert("密码不能为空");
			password.focus();
			return false;
		} else if (password.value != repassword.value){
			alert("密码不一致");
			password.focus();
			return false;
		} else if (name.value == "") {
			alert("姓名不能为空");
			name.focus();
			return false;
		} else if (tel.value == "" || !(/^1[34578]\{9}$/.test(tel.value))) {
			alert("手机号格式有误");
			tel.focus();
			return false;
		}
		
		return true;
	}
</script>
</body>
</html>