<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div.hide, .hide1, .hide2{
		display:none;
	}
	
	div.no_hide1, .no_hide2{
		display:block;
	}
	
	div.popup{
		width:70%;
		height:50%;
		position:static;
		margin:0px auto;
		background-color: #000;		
	}
	div.noUser{
		width:30%;
		height:10%;
		position:static;
		margin: 0px auto;
		background-color: #eee;
		padding:100px;
	}
	span.noUserMsg{
		padding:100px;
	}
	div.button{
		background-color: gray;
		border-radius: 5px;
	}
	
</style>
</head>
<body>
	<form method="post" action="/createBag" enctype="multipart/form-data">
		info:
		<input type="text" name="info" /><br /> 
		member 이메일만 입력 됨ㅋ:
		 <input type="text" name="user" id="addMember"/>
		<span id="addButton">추가 </span><br/>
		<div class="members">
			<span class="user"></span>
		</div>
		대표 이미지 upload: 대표 이미지: <input type="file" name="file" />
		<div class="prevImg"></div>
		<input type="hidden" name="userList" id="hidden" value=""/>
		<button type="submit">제출</button>
	</form>
	<div class="mailSender hide">
		<div class="popup hide1">
			<div class="noUser hide1">
				<span class="noUserMsg hide1"> no user sendmail </span>
				<div class="button hide1">
					<span class="hide1 buttonMsg" id="email">SEND EMIAL</span>
					<span class="cancel hide1">not now </span>
				</div>
			</div>
			<div class="mail hide2">
				<input type="text" class="customMsg hide2"/>
				<div class="button hide2">
					<span class="buttonMsg hide2" id="send">SEND EMIAL</span>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="/../js/ajax.js"></script>
<script src="/../js/bagForm.js"></script>
</html>