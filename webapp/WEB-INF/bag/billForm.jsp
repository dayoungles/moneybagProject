<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>
<container>
	<form method="post" action="/bill/create/${bagId}" enctype="multipart/form-data">
		어디에 썼음?: <input type="text" name="billName"/></br>	
		사용 금액 : <input type="text" name="usedMoney"/></br>	
		사용 이유 상세:<input name="info" type="text"/></br>	
		영수증 사진: <input type="file" name="file"></br>		
		
		<button>제출하기 </button>
	</form> 
</container>

<%@ include file="/WEB-INF/footer.jsp" %>