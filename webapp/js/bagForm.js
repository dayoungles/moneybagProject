/**
 * add User as a member of moneybag with ajax
 */

var el_input = document.getElementById("addMember");
var btn = document.getElementById("addButton");
var submitBtn = document.querySelector("button[type='submit']");
var emailAdrs;
// ajax통신으로 존재하는 유저인지 확인하는 함수
btn.addEventListener("click", function() {
	emailAdrs = el_input.value;
	var oAjax = new ajax("GET", "/api/addMember?email=" + emailAdrs, (function(
			response) {
		if (response != "") {
			var el_member = document.querySelector(".members");
			var span_cloned = el_member.querySelector(".user").cloneNode(true);
			var userInfo = JSON.parse(response);
			span_cloned.innerHTML = userInfo.name + " ";
			span_cloned.setAttribute("value", userInfo.id);
			el_member.insertAdjacentElement("beforeend", span_cloned);
		} else {
			var page = document.querySelector(".mailSender");
			page.className = "mailSender";
			var elements = page.querySelectorAll(".hide1");
			for (var i = 0; i < elements.length; i++) {
				var className = elements[i].className;
				elements[i].className = className.replace("hide1", "no_hide1");
			}

		}
	}).bind(this));
	oAjax.service();
});

submitBtn.addEventListener("click", function() {
	// span에 들어있는 멤버들 이름을 모두 찾아서 배열로 생성해서 서버로 전송
	var userList = document.getElementsByClassName("user");
	var nameList = "";
	var userSize = userList.length;
	for (var i = 1; i < userSize; i++) {// sample span제외하고 1부터 시작
		nameList += userList[i].getAttribute("value") + ",";
	}
	var hiddenVal = document.getElementById("hidden");
	hiddenVal.value = nameList;
});

var emailBtn = document.querySelector("#email");
emailBtn.addEventListener("click", function() {
	// mailSender아래의 no_hide1 클래스를 모두 찾아서 hide1로 변경한다.
	var popup = document.querySelector(".popup");
	var eles = popup.querySelectorAll(".no_hide1");
	for (var i = 0; i < eles.length; i++) {
		var className = eles[i].className;
		eles[i].className = className.replace("no_hide1", "hide1");
	}
	// mailSender 이하 hide2클래스를 모두 찾아서 no_hide2로 변경한다.
	var hide2s = popup.querySelectorAll(".hide2");
	for (i = 0; i < hide2s.length; i++) {
		var className = hide2s[i].className;
		hide2s[i].className = className.replace("hide2", "no_hide2");
	}
});

var sendBtn = document.querySelector("#send");
sendBtn
		.addEventListener(
				"click",
				function() {
					// mailSender이하 no-hide2를 모두 hide2로 바꾸고
					var popup = document.querySelector(".popup");
					var no_hide2s = popup.querySelectorAll(".no_hide2");
					for (i = 0; i < no_hide2s.length; i++) {
						var className = no_hide2s[i].className;
						no_hide2s[i].className = className.replace("no_hide2",
								"hide2");
					}
					// ajax를 통해서 input.customMsg.value를 서버로 전송한 후, 메일을 보낸다.
					var msg = document.querySelector("input.customMsg").value;
					var oAjax = new ajax(
							"GET",
							"/api/sendEmail?msg=" + msg + "&email=" + emailAdrs,
							function(response) {
								if (response === "success") {
									alert("send email success너는 잘 모르겠지만 난 무척 기쁘단다. 왜냐하면 자바스크립트가 날파리 몇개 잡고 실행됐거든...CSS만 잡으면 되는데 감동과 충격의 도가니다. 다른 애들은 이 단계를 이미 다 지나서 이렇게 재밌는거겠지;;;;");
								}

							});
					oAjax.service();
					// 메일 유효성 검사에 의해서 메세지가 돌아오지 않을 경우 그냥 취소 시키고 진행한다.
					// 나는 UX 따위보다 내가 이벤트리스너를 다루는게 중요하까.
				});
