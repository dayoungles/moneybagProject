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
	test page 
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
	<button id="ajaxButton">ajax test</button>
	<input type="text" name="addMember" url="/api/addMember" />
	
	<script src="../js/ajax.js"></script>
	<script>
	  document.getElementById("ajaxButton").addEventListener("click", function() { 
	
			var test = new ajax("POST", "/api/test", function(response){
				alert(response);
			});
			test.service();
	 });
	  
	 var _input =document.querySelector("input[name='addMember']"); 
	 _input.addEventListener("keydown", function(e){
			var key = e.which || e.keyCode;
			if(key===13) {
 				var oAjax = new ajax("GET", "/api/addMember?name="+this.value, function(response){
					alert(response);
				});
				oAjax.service();
				
			}
	 }); 
		 
	 
	</script>
</body>
</html>