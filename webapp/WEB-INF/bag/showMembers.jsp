<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/WEB-INF/header.jsp"%>
<container>
	<div class="memberBox" >
		<c:forEach var="user" items="${memberList}">
			<div class="member">
				<span>${user.name}</span>
				<img src="/userImg/${user.fileName}"/>
			</div>
		</c:forEach>
	</div>
	
</container>