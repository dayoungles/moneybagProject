<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>
<container>
<div class="line" id="line1">
	<c:forEach var="bag" items="${bagList}">
		<div class="bag" id="${bag.id}"	style="background-image:url(/bagImg/${bag.fileName}); background-size: 100% 100%; border-radius: 25px; margin: 10px 40px; padding: 10px;">
			<a href="/showBag/${bag.id}"> 모임명: ${bag.info}<br /> 모임이 시작된 날:<br />
				${bag.createdDate}<br />
			</a>
		</div>
	</c:forEach>
</div>
</container>
<%@ include file="/WEB-INF/footer.jsp"%>