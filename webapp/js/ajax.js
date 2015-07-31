/**
 * sample : var test = new ajax("GET", "/url/test", callbackfunction ); - post일
 * 경우 test.setMethod(만들어놓은 컨텐츠 );// 이 컨텐츠는 key=value&key1=value1;이런식으로 스크립트에서 직접
 * 만들어서 보내야되는 녀석임. post로 보낼 예정 test.service();
 */

var ajax = function(method, url, callback) {
	this.httpRequest;
	this.contents;// send(param)
	this.method = method;
	this.url = url;
	this.callback = callback;
	// this.service();
};

/**
 * 메소드가 포스트일 경우 url형식으로 만들어 보내기 위해서 POST인 경우에 대해서만 만들었음. 내가 PUT을 쓸 것 같지 않음;
 */
ajax.prototype.setMethod = function(content) {
	if (this.method === "POST") {
		this.httpRequest.setRequestHeader('Content-Type',
				'application/x-www-form-urlencoded');// MIME type...
	}
	this.content = content;
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

ajax.prototype.getResponse = function() {
	if (this.httpRequest.readyState === 4) {
		if (this.httpRequest.status === 200) {
			this.callback(this.httpRequest.responseText);
		} else {
			alert('There was a problem with the request.');
		}
	}
};

ajax.prototype.service = function(param) {
	this.setHTTP();
	this.httpRequest.onreadystatechange = this.getResponse.bind(this);
	this.httpRequest.open(this.method, this.url, true);
	this.setMethod(param);
	this.httpRequest.send(this.contents);
};
