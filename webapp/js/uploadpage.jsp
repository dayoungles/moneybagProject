<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	div.prevImg{
		width:200px;
		height:200px;
		border:1px solid black;
	}
</style>

</head>
<body>
	<form method="post" action="/createBag" enctype="multipart/form-data">
		info:<input name="info" /><br />
		 member:  <input	name ="user1" /><br />
		 ëí ì´ë¯¸ì§ upload: <input type="file" name="file"/><br/>
		 <div class="prevImg">
			 <span id="uploadImg"/>
			 img insert
		 </div>
		<button type ="submit">ì ì¶</button>
	</form>
	<button id="ajaxButton">ajax</button>
	<script src="../js/testAjax.js"/>
</body>
</html>