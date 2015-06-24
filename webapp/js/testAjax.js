var util = new Util();

util.ajax.get("http://www.jkdl", function(data){
	
})

util.ajax({method: "get", url: ""});


var elImg = document.getElementsById("imgPos");
console.log(elImg+"              /////////////////test");
debugger;
var presentUrl = elImg.getAttribute('src');


   var client = util.httpRequest;
  
   function upload() 
   {
      var file = document.getElementById("uploadfile");
     
      /* Create a FormData instance */
      var formData = new FormData();
      /* Add the file */ 
      formData.append("upload", file.files[0]);

      client.open("post", "/api/upload", true);
      client.setRequestHeader("Content-Type", "multipart/form-data");
      client.send(formData);  /* Send to server */ 
   }
     
   /* Check the response status */  
   client.onreadystatechange = function() 
   {
      if (client.readyState == 4 && client.status == 200) 
      {
         alert(client.statusText);
      }
   }