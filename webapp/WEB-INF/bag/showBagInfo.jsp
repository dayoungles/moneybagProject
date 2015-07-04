<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<container>
<div class="bagArea">
	<div class="info">${bag.info}</div>
	<a href="/bill/form/${bag.id}"><button>새로운 사용내역 등록하기</button></a>
	<c:forEach var="bill" items="${billList}">
		<div class="bill">
			날짜: ${bill.createdDate}<br /> 사용금액:<br />
		</div>
	</c:forEach>


</div>
</container>

<%@ include file="/WEB-INF/footer.jsp"%>