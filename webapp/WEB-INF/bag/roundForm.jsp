<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>
<container>
	<form:form modelAttribute="round" method="post" action="/inputRound/${bagId}">
		회차 정보 :<form:input path="info"/>
		총 액: <form:input path="total"/>
		n빵 여부 :<form:checkbox path="nBang"/>
		<button>제출하기 </button>
		<!-- 멤버를 추가하는 드롭다운박스도 만들어야 하는데 일단 생략 -->
	</form:form> 
</container>

<%@ include file="/WEB-INF/footer.jsp" %>