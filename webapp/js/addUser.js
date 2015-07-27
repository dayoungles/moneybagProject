/**
 * add User as a member of moneybag with ajax 
 */

var _userName = document.getElementByid("member");
_userName.addEventListener("keydown", ajax(e));

function ajax(e){
	var key = e.keyCode || e.which;
	if(key === 13){
		e.preventDefault();
		var msg = this.value;
		var response = ajaxModule(msg, "/api/addMemberToBag");
		
		if(response === "existUser OK"){
			//유저 이름을 하단에 등록.
			
		}else{
			//alert ("가입하지 않은 유저입니다 서비스로 초대하세요 ");
			//alert ("가입 요청 메세지, 초대할 메일 주소 prompt입력 ");
			//입력 받은 정보를 다시 api/sendInviteMSG해서 메일 전
		} 
	}
	

	
}
