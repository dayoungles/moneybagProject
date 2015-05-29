/**
 * util을 만들어 놓을까 합니다. 
 * 1. ajax
 * 
 */
Util = {
	var httpRequest :null,
	var method :"GET",
	
};

//해당 ajax의 method를 외부에서 결정해줄 수 있도록. 기본은 Get으로 설정한다. 
Util.prototype.setMethod=function(method){
	this.method = method;
};

Util.prototype.setJson = funtcion(){
	this.httpRequest.setRequestHeader('Accept', 'application/json');
};

Util.prototype.setSimplePost = function(){
	this.httpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
}

Util.prototype.open = function(){
	this.httpRequest.open(method, sUrl);
	
}

Util.prototype.send = function(params) {
	this.httpRequest.send(params);
}
	
//ajax함수.prototype의 함수 내의 다른 것들은 private하게 생성했다. 
Util.prototype.ajax=function(url, workingFunction, errorFunction){
	var httpRequest = this.httpRequest;
	var method = this.method;
	

	
	if(window.ActiveXObject) {
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if(window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	}
	
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			temp = httpRequest.responseText;//돌려받은 메세지 여기있당. 이거 어떻게 처리할지
			workingFunction(temp);
		}
	}
	
/*
	createXMLHttpRequest(httpRequest).bind(this);
	httpRequest.onreadystatechange = loader(workingFunction, httpRequest).bind(this);
	httpRequest.open(method, url, true);
	httpRequest.send(null);
*/
}

function createXMLHttpRequest(httpRequest) {
	if(window.ActiveXObject) {
		httpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if(window.XMLHttpRequest) {
		httpRequest = new XMLHttpRequest();
	}
}


function loader(workingFunction, httpRequest) {
	if(httpRequest.readyState == 4) {
		if(httpRequest.status == 200) {
			temp = httpRequest.responseText;//돌려받은 메세지 여기있당. 이거 어떻게 처리할지
			workingFunction(temp);
		}else {
			errorFunction();
		}
	} else {
		errorFunction();
	}
}
