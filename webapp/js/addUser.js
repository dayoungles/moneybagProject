/**
 * add User as a member of moneybag with ajax
 */

var el_input = document.getElementById("addMember");
var btn = document.getElementById("addButton");
btn.addEventListener("click", function(){
	var name = el_input.value;
	var oAjax = new ajax("GET", "/api/addMember?name=" + name,
			(function(response) {
				if (response === "true") {
					var el_member = document.querySelector(".members");
					var span_cloned = el_member.querySelector(".user")
							.cloneNode(true);
					span_cloned.innerHTML = name + " ";
					el_member.insertAdjacentElement("beforeend", span_cloned);
				} else {
					alert("없는 사용자임..메일을 보내봅시다 ");
				}
			}).bind(this));
	oAjax.service();
});
