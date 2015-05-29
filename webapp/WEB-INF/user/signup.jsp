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
	signup page<br/>
	<form:form method="post" action="/signup/insert" modelAttribute="user">
		email:<form:input path="email"/>
		password<form:password path="password"/>
		name:<form:input path="name"/>
		<button type="submit">submit </button>
	</form:form>
</body>
</html>