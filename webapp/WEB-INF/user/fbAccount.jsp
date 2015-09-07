<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action='/signup/addAccount' method="POST">
		
		<input type="hidden" name="name" value="${name}" />
		<input type="hidden" name="facebookId" value="${fId}" />
		은행 선택 : 
		<select>
			<option value="woori">우리은행</option>
			<option value="shinhan">신한은행</option>
			<option value="hana">하나은행</option>
			<option value="kb">국민은행</option>
		</select> 
		계좌번호 입력 <input type="text" name="account" />
		<input type="submit" value="submit"/>
	</form>
</body>
</html>