<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<sidebar>
	<div class="moneybagForm">
		<div class="hyper">
			<a href="/moneybagPayCheck/${bagId}" class="register"><span
				id="checkPayment">지불체크</span></a><br />
		</div>
		<div class="hyper">
			<a href="/bill/form/${bagId}" class="register"><span
				id="uploadBill">새로운 사용내역 등록</span></a><br />
		</div>
		<div class="hyper">
			<a href="/user/showMembers/${bagId}" class="register"><span
				id="member">멤버 보기</span></a><br />
		</div>
		<div class="hyper">
			<a href="/board/list/${bagId}" class="register"><span
				id="freeboard">자유게시판</span></a><br />
		</div>
	</div>
</sidebar>

</body>
</html>