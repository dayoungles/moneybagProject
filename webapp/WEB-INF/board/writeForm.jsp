<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>

<container>
	<div class="writing">
		<form action="/board/writing" method="POST">
			<input type="hidden" name="writerId" value="${userId}"/>
			<input type="hidden" name="moneybagId" value="${moneybagId}"/>
			<input type="text" name="title" />
			<input type="text" name="content" />
			<button type="submit">post</button>
		</form>
	</div>	

</container>


<%@ include file="/WEB-INF/bag/showbagInfoMenu.jsp"%>