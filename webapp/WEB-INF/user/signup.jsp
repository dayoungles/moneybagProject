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
	<form method="post" action="/signup/testinsert" enctype="multipart/form-data">
		<!-- user -->
		email:<input type="text" name="email"/>
		password<input type="text" name="password"/>
		name:<input type="text" name="name"/>
		account:<input type="text" name="account"/>
		
		<!-- image upload --> 
		대표 이미지: <input type="file" name="multipartFile"/>
		<input type="hidden" name="nameOfmf" value="test"/>
		
		<input type="submit" name="submit" value="submit"/> 
	</form>
</body>
</html>