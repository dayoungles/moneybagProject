<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/header.jsp"%>

<container>
<div class="boardList">
	<c:choose>
		<c:when test="${not empty boardList}">
			<c:forEach var="board" items="${boardList}">
				<a href="/board/showBoard/${board.boardId}">
					<div class="board">
						title:${board.title}<br /> upload time:${board.time }<br />
						writer:${board.writer }<br /> hits: ${board.hits }<br />
					</div>
				</a>
			</c:forEach>
		</c:when>
	</c:choose>
</div>
<div class="writing">
	<a href="/board/writePage/${bagId}"><span>write</span></a>
</div>
</container>


<%@ include file="/WEB-INF/bag/showbagInfoMenu.jsp"%>