package email;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class EmailSendService {
	
	@Autowired
	private MailSender mailSender;
	
	public void sendJoinEmail(User user, String email){
		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo(email);
		msg.setFrom("make.work1234@gmail.com");
		msg.setSubject(user.getName()+" wants you");
		msg.setText("body message join this service for our group!");
		
		this.mailSender.send(msg);
	}
}
