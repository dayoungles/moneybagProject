/**
 * 
 */

var ajax = function(method, url, callback) {
	this.httpRequest;
	this.method = method;
	this.url = url;
	this.callback = callback;
	this.service();
};

ajax.prototype.setHTTP = function() {

	if (window.XMLHttpRequest) { // Mozilla, Safari, ...
		httpRequest = new XMLHttpRequest();
	} else if (window.ActiveXObject) { // IE
		try {
			httpRequest = new ActiveXObject("Msxml2.XMLHTTP");
		} catch (e) {
			try {
				httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
			} catch (e) {
			}
		}
	}

	if (!httpRequest) {
		alert('Giving up :( Cannot create an XMLHTTP instance');
		return false;
	}
	this.httpRequest = httpRequest;

};

ajax.prototype.getResponse  = function(){
	if (this.httpRequest.readyState === 4) {
		if (this.httpRequest.status === 200) {
			this.callback(this.httpRequest.responseText);
		} else {
			alert('There was a problem with the request.');
		}
	}
};

ajax.prototype.service = function() {
	this.setHTTP();
	this.httpRequest.onreadystatechange = this.getResponse.bind(this);
	this.httpRequest.open(this.method, this.url);
	this.httpRequest.send();
};

// var test = new ajax("GET", "/api/test", function test(){
// console.log(this.httpRequest.responseText);
// });
//
//
// test.service();

