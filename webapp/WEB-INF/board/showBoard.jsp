<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>
<container>
	<div class="board">
		<div class="title">
			<span class="title">${board.title}</span>
		</div>
		
		<div class="info">
			<span class="hits">조회수: ${board.hits}</span>
			<span class="dateTime">작성시간: ${board.time}</span>
			<span class="writer">작성자: ${user}</span>
			
		</div>
		<div class="content">
			<span class="content">${board.content}</span>		
		</div>
		 
	</div>
</container>
<%@ include file="/WEB-INF/bag/showbagInfoMenu.jsp"%>