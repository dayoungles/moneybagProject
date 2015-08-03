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
	<form method="post" action="/createBag" enctype="multipart/form-data">
		info:
		<input type="text" name="info" /><br /> 
		member 이메일만 입력 됨ㅋ:
		 <input type="text" name="user" id="addMember"/>
		<span id="addButton">추가 </span><br/>
		<div class="members">
			<span class="user"></span>
		</div>
		대표 이미지 upload: 대표 이미지: <input type="file" name="file" />
		<div class="prevImg"></div>
		<input type="hidden" name="userList" id="hidden"/>
		<button type="submit">제출</button>
	</form>
</body>
<script src="/../js/ajax.js"></script>
<script src="/../js/addUser.js"></script>
</html>