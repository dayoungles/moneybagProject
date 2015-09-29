<html>
	<head>
		<script src="/js/ajax.js"></script>
	</head>
	<body>
		<div class="test">

		</div>
	<script>
	
		var firstAdd="https://api.fitbit.com/1/user/";
		var secondAdd= "/body/date/2015-03-01.json";
		var userEncodedId="229TZR";
		var oAjax = new ajax("GET", firstAdd+userEncodedId+secondAdd, function(response){
			alert(response);
		});
		
		//request header설정 
	 	
	</script>
	</body>
</html>