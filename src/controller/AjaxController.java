package controller;

import javax.servlet.http.HttpSession;

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
import service.BagService;
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

	@Autowired
	BagService bagService;

	@RequestMapping(value = "/test")
	public @ResponseBody String testAjax() {

		return "test succeddddddd";
	}

	/**
	 * 이미 가입된 유저인지 확인하는 함수. boolean값을 String으로 반환한다.
	 * 
	 * @param name
	 * @return boolean value in String
	 */
	@RequestMapping(value = "/addMember")
	// @RequestMapping(value="/addMember", method=RequestMethod.POST)
	public @ResponseBody String testAddmember(@RequestParam("email") String email) {
		User user = null;
		if (userService.isExistUser(email)) {
			user = userService.selectUserByEmail(email);
			logger.debug("{\"userId\":" + user.getId() + ", \"userName+\":" + user.getName() + "}");
			return "{\"userId\":\"" + user.getId() + "\", \"userName\":\"" + user.getName() + "\"}";
		} else {
			return "false";
		}
	}

	@RequestMapping("/upload")
	public String uploadForm() {
		return "uploadpage";
	}

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(@RequestParam("email") String email, @RequestParam String msg, HttpSession session) {
		logger.debug("email:{}, user:{}", email, (User)session.getAttribute("user"));
		emailSender.sendJoinEmail((User)session.getAttribute("user"), email, msg);
		return "success";
	}
}
