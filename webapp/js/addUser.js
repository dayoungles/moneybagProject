/**
 * add User as a member of moneybag with ajax
 */

var el_input = document.getElementById("addMember");
var btn = document.getElementById("addButton");
var submitBtn = document.querySelector("button[type='submit']");

//ajax통신으로 존재하는 유저인지 확인하는 함수 
btn.addEventListener("click", function(){
	var email = el_input.value;
	var oAjax = new ajax("GET", "/api/addMember?email=" + email,
			(function(response) {
				if (response !="") {
					var el_member = document.querySelector(".members");
					var span_cloned = el_member.querySelector(".user")
							.cloneNode(true);
					var userInfo = JSON.parse(response);
					span_cloned.innerHTML = userInfo.userName + " ";
					span_cloned.setAttribute("value", userInfo.userId);
					el_member.insertAdjacentElement("beforeend", span_cloned);
				} else {
					alert("없는 사용자임..메일을 보내봅시다 ");
				}
			}).bind(this));
	oAjax.service();
});

submitBtn.addEventListener("click", function(){
	//span에 들어있는 멤버들 이름을 모두 찾아서 배열로 생성해서 서버로 전송
	var userList = document.getElementsByClassName("user");
	var nameList="";
	var userSize = userList.length;
	debugger;
	for(var i=1; i< userSize; i++){//sample span제외하고 1부터 시작
		nameList += userList[i].getAttribute("value");
		if(i != userSize-1)
			nameList +=",";
			
		
	}
	console.log(nameList);
	var hiddenVal = document.getElementById("hidden");
	hiddenVal.value = nameList;
	
});

