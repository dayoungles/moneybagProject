<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/user/login.css">
</head>

<body>
	<div class="loginBox">
		<div class="box">
			<form:form modelAttribute="user" method="post"
				action="/user/loginCheck">	
			<form:input path="email" class="input" placeholder="EMAIL"/>
				<br />
			<form:password path="password" class="input" placeholder="PASSWORD"/>
				<br />
				<button type="submit">제출</button>
			</form:form>
		</div>
	</div>
</body>
</html>