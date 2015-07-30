/**
 * 
 */

var ajax= function(method, url, callback){
	this.httpRequest;
	this.method = method;
	this.url = url;
	this.callback = callback;
};

ajax.prototype.setHTTP = function(){
	
	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
		      httpRequest = new XMLHttpRequest();
		    } else if (window.ActiveXObject) { // IE
		      try {
		        httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		      } 
		      catch (e) {
		        try {
		          httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
		        } 
		        catch (e) {}
		      }
		    }
		    
		    if (!httpRequest) {
		      alert('Giving up :( Cannot create an XMLHTTP instance');
		      return false;
		    }
		    this.httpRequest = httpRequest;

};

ajax.prototype.service = function (){
	test.setHTTP();
	test.httpRequest.onreadystatechange = test.callback;
    httpRequest.open(test.method, test.url);
    httpRequest.send();
}

//var test = new ajax("GET", "/api/test", function test(){
//	console.log("test success");
//});
//
//
//test.service();



