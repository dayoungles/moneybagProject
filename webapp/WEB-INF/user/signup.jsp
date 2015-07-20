<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	signup page
	<br />
	<form:form method="post" action="/signup/insert" modelAttribute="user"
		enctype="multipart/form-data">
		email:<form:input path="email" />
		<form:errors path="email" cssClass="error" />
		<br />
		password:<form:password path="password" />
		<form:errors path="password" cssClass="error" />
		<br />
		name <form:input path="name" />
		<form:errors path="name" cssClass="error" />
		<br />
		
		account	<form:input path="account" />
		<form:errors path="account" cssClass="error" />
		<br />

		<!-- image upload -->
		 대표 이미지: <input type="file" name="multipartFile" />

		<input type="submit" name="submit" value="submit" />

	</form:form>
</body>
</html>