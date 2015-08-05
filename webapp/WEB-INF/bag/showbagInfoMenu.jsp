<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

	<sidebar>
		<div class="moneybagForm">
			<a href="/moneybagPayCheck/${bagId}" class="register">지불체크</a><br/>
			<a href="/bill/form/${bagId}" class="register">새로운 사용내역 등록하기</a><br/>
			<a href="/user/showMembers/${bagId}">멤버 보기 </a><br/>
			<a href="/board/list/${bagId}">자유게시판 </a><br/>
		</div>
		
	</sidebar>

</body>
</html>