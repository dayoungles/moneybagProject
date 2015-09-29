<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<%@ include file="/WEB-INF/header.jsp"%>
<link rel="stylesheet" type="text/css" href="/css/user/login.css">
<link rel="stylesheet" type="text/css" href="/css/bagForm.css">

<container>
	<div class="loginBox">
		<div class="box">
			<form method="post" action="/createBag"  onsubmit="return event.keyCode != 13;"  
			enctype="multipart/form-data">
				<input type="text" name="info" class="input" placeholder="Moneybag name"/><br />
				<input type="text" name="user" class="input" id="addMember" placeholder="Add member's name or email"/> 
				<span id="addButton">추가</span><br />
				<div class="members">
					<span class="user"></span>
				</div>
				대표 이미지 upload: 대표 이미지: <input type="file" name="file" />
				<div class="prevImg"></div>
				<input type="hidden" name="userList" id="hidden" value="" />
				<button type="submit">제출</button>
			</form>
		</div>
	</div>
	
	<div class="mailSender hide">
		<div class="popup hide1">
			<div class="noUser hide1">
				<span class="noUserMsg hide1"> no user sendmail </span>
				<div class="button hide1">
					<span class="hide1 buttonMsg" id="email">SEND EMIAL</span> <span
						class="cancel hide1">not now </span>
				</div>
			</div>
			<div class="mail hide2">
				<input type="text" class="customMsg hide2" />
				<div class="button hide2">
					<span class="buttonMsg hide2" id="send">SEND EMIAL</span>
				</div>
			</div>
		</div>
	</div>
</container>
<%@ include file="/WEB-INF/footer.jsp"%>
<script>
	var info =document.querySelector('input[name="info"]');
	
</script>
<script src="/../js/ajax.js"></script>
<script src="/../js/bagForm.js"></script>
</html>