<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="/css/user/login.css">
<title>Insert title here</title>
</head>
<body>
	signup page
	<br />
	<div class="signupBox">
		<div class="box">
			<form:form method="post" action="/signup/insert"
				modelAttribute="user" enctype="multipart/form-data">
				<form:input path="email" class="input" placeholder="EMAIL" />
				<form:errors path="email" cssClass="error" />
				<br />
				<form:password path="password" class="input" placeholder="PASSWORD" />
				<form:errors path="password" cssClass="error" />
				<br />
				<form:input path="name" class="input" placeholder="NAME" />
				<form:errors path="name" cssClass="error" />
				<br />

				<form:input path="account" class="input" placeholder="BANK ACCOUNT" />
				<form:errors path="account" cssClass="error" />
				<br />

				<!-- image upload -->
		 대표 이미지: <input type="file" name="multipartFile" />

				<input type="submit" name="submit" value="submit" class="button"/>

			</form:form>
		</div>
	</div>
</body>
</html>