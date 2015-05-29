<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp" %>
	<container>
		<div class="line" id="line1">
			<c:forEach var="bag" items="${bagList}"  >
				<a href="/showBag/${bag.id}">
					<div class="bag" id= "${bag.id}">
						${bag.info}<br/>
						${bag.id}<br/>
						${bag.createdDate}<br/>
					</div>
				</a>
			</c:forEach>
		</div>
	</container>
<%@ include file="/WEB-INF/footer.jsp" %>