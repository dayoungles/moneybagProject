package controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import model.FileUpload;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.UploadService;
import service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {

	private static final Logger logger = LoggerFactory
			.getLogger(SignupController.class);

	@Autowired
	private UserService userService;
	
	@Autowired
	private UploadService uploadService;
	
	@RequestMapping("/form")
	public String signupForm(Model model) {
		
		return "/user/signup";
	}

	/*
	 * User의 정보를 받아서 그 user를 db에 삽입
	 * //	
	 * @return String "index"
	 */

	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String createUser(User user, @RequestParam("multipartFile") MultipartFile file, Model model,
			HttpSession session) {
		logger.debug("file:{}", file.toString() );
		if(userService.isExistUser(user.getEmail())){
			return "/user/login";//재가입 시켜 이메일 중복이라고. 알림 띄워줘야 된다는.  
		}		
		FileUpload upload = uploadService.fileSetting(file);
		user.setFileName(upload.getName());
		userService.insertUser(user);
		
		session.setAttribute("user",
				userService.selectUserByEmail(user.getEmail()));
		return "redirect:/index";
	}
	

}
