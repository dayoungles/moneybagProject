package email;
import model.Email;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendJoinEmail(User user, String email, String customMsg){
		if(isValidEmail(email)==false){
			return;//exception 발생 
		}
		Email mail = new Email(user, email);
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setFrom(mail.getFrom()); 
		msg.setSubject(mail.getSubject());
		msg.setText(mail.getBodyText()+". "+customMsg);
		
		this.mailSender.send(msg);
	}
	
	private boolean isValidEmail(String email){
	
		return true;
	}
	
}
