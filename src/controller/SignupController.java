package controller;

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
	public String createUser(User user, FileUpload upfile, Model model,
			HttpSession session) {
		logger.debug("user:{}", user);
		logger.debug("file:{}", upfile);
//		FileUpload upload = new FileUpload(file);
//		if(!userService.isExistUser(user.getEmail())){
//			return "/user/login";//재가입 시켜 이메일 중복이라고. 알림 띄워줘야 된다는.  
//		}
//		logger.debug("FileUpload:{}", upfile);
//		userService.insertUser(user);
//		uploadService.fileSetting(upfile, user.getId());
//		user.setFileName(upload.getName());//getName궁금. 
		
//		userService.modifyUser();
//		session.setAttribute("user",
//				userService.selectUserByEmail(user.getEmail()));
		return "redirect:/index";
	}
	
	@RequestMapping(value="/testinsert", method=RequestMethod.POST)
	public String testInsert(User user, FileUpload file, Model model, HttpSession session){
		logger.debug("user:{}", user);//잘 나옴. 빈 객체가 문제가 아님. 
		logger.debug("file:{}", file);
		
		return "redirect:/index";
	}
	

}
