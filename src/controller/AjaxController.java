package controller;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import email.EmailSendService;
import service.UploadService;
import service.UserService;

@Controller
@RequestMapping("/api")
public class AjaxController {
	

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	UploadService uploadService;

	@Autowired
	UserService userService;
	
	@Autowired
	EmailSendService emailSender;
	
	@RequestMapping(value="/test")
	public @ResponseBody String testAjax() {

		return "test succeddddddd";
	}
	
	@RequestMapping(value="/addMember")
//	@RequestMapping(value="/addMember", method=RequestMethod.POST)
	public @ResponseBody String testAddmember(@RequestParam("name") String name) {
		return String.valueOf(userService.isExistUserName(name));
		
	}

	@RequestMapping("/upload")
	public String uploadForm() {
		return "uploadpage";
	}

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(@RequestParam("email") String email){
		logger.debug("email:{}", email);
		emailSender.sendJoinEmail(new User(), email);
		return "success";
	}
}
