<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ include file="/WEB-INF/header.jsp"%>
<container>
<div class="line" id="line1">
	<c:forEach var="bag" items="${bagList}">
		<div class="bag" id="${bag.id}">
			<a href="/showBag/${bag.id}">
				<div class="info bagImg" style="background-image:url(/bagImg/${bag.fileName});"></div>
				<div class="info info_box">
					<p class="title">${bag.info}</p>
					<p class="since">${bag.createdDate}</p>
				</div>
			</a>
		</div>
	</c:forEach>
</div>
</container>
<%@ include file="/WEB-INF/footer.jsp"%>