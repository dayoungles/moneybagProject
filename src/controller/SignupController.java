package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.FileUpload;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import exception.ValidException;
import service.UploadService;
import service.UserService;

@Controller
@RequestMapping("/signup")
public class SignupController {

	private static final Logger logger = LoggerFactory.getLogger(SignupController.class);
	private static final String USER_IMG_FOLDER = "userImg/";
	@Autowired
	private UserService userService;

	@Autowired
	private UploadService uploadService;

	@RequestMapping("/form")
	public String signupForm(Model model) {
		model.addAttribute("user", new User());
		return "/user/signup";
	}

	/*
	 * User의 정보를 받아서 그 user를 db에 삽입 
	 * 
	 * @return String "index"
	 */
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createUser(@Valid User user, BindingResult result, @RequestParam("multipartFile") MultipartFile file, Model model,
			HttpSession session, HttpServletRequest request) throws Exception {

		try {
			userService.isExistUser(user.getEmail()) ;
			userService.checkSignupValidation(result);
		} catch (NotExistException ne) {
			ne.getMessage();
			//TODO 에러 메세지 전달 
//			model.addAttribute("message", ne.getMessage());
			return "redirect:/errorPage/"+ne.getMessage();
		}catch(ValidException ve){
			model.addAttribute("message", ve.getMessage());
			return "redirect:/errorPage"+ve.getMessage();
		}
		
		FileUpload uploaded = uploadService.uploadFileToFolder(file, USER_IMG_FOLDER);
		user.setUserFileName(uploaded.getName());
		userService.insertUser(user);

		model.addAttribute(user);
		session.setAttribute("user", userService.selectUserByEmail(user.getEmail()));
		return "redirect:/index";
	}


	@RequestMapping("/testValid")
	public String testValidation(@Valid User user, BindingResult result) {

		if (result.hasErrors()) {
			logger.info("valid 어라");
			List<ObjectError> errors = result.getAllErrors();
			for (ObjectError error : errors) {
				logger.debug("error:{}", error.getDefaultMessage());
			}
			return "redirect:/user/login";
		}
		return "redirect:/index";
	}

	
	@RequestMapping("/addAccount")
	public String createUserWithFacebook(@RequestParam("facebookId") String fId, @RequestParam("name")String name, 
			@RequestParam("account")String account, HttpSession session, Model model) throws Exception{
		User user = new User(fId, name);
		//facebook에서 사진 정보 가지고 올 필요 없지 않을까. 그때그때 요청해서 뿌릴 수 있도록 해도 괜찮을 듯 하다. 
		userService.insertUser(user, account);
		
		session.setAttribute("user", userService.getUserJoinedByFacebook(user.getFacebookId()));
		
		return "redirect:/index";
	}
}
