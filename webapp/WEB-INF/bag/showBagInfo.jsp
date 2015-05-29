<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<container>
<div class="bagArea">
	<div class="info">${bag.info}</div>
	<a href="/roundForm/${bag.id}"><button>새로운 모금 회차 생성</button></a>
	<c:forEach var="round" items="${roundList}">
		<div class="round">
			날짜: ${round.createdDate}<br /> 사용금액: ${round.total}<br />
		</div>
	</c:forEach>


</div>
</container>

<%@ include file="/WEB-INF/footer.jsp"%>