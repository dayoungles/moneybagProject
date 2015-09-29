package model;

public class Email {
	public String subject = "Your friend "+ this.user + " invited you to join moneybag service";
	public String bodyText="join moneybag Service by click under validation code.";
	public final String from = "make.work1234@gmail.com";
	public String user;
	public String to;
	
	public Email(User user2, String email) {
		this.user= user2.getName();
		this.to = email;
	}

	public void setDefaultEmail(User user, String email){
		this.user = user.getName();
		this.to = email;
		setValidationCode();
	}

	public void setValidationCode(){
		String code= "validation code~~~";//확인 코드 받자요 여기에 들어가야 할 정보는 초대한 moneybag id. 
		this.bodyText += code;
	}

	public String getFrom() {
		return from;
	}
	
	public String getBodyText(){
		return bodyText;
	}

	public String getSubject() {
		return subject;
	}

	public String getUser() {
		return user;
	}

}
