package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.FileUpload;
import model.User;

import org.apache.jasper.tagplugins.jstl.core.ForEach;
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
		model.addAttribute("user", new User());
		return "/user/signup";
	}

	/*
	 * User의 정보를 받아서 그 user를 db에 삽입 //
	 * 
	 * @return String "index"
	 */

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String createUser(@Valid User user, BindingResult result,
			@RequestParam("multipartFile") MultipartFile file, Model model,
			HttpSession session, HttpServletRequest request) {

		// validation 에러 발생 시
		if (result.hasErrors()) {
			logger.info(" 유효성 에러 ");
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				logger.debug("error:{}", error.getDefaultMessage());
			}

			return "user/signup";

		}
		if (userService.isExistUser(user.getEmail())) {
			return "이미 가입된 이메일입니다.";// 물론 이렇게 하면 에러가 납니다 ^_^ requestBody를 이용해서
									// js로 처리하는 방법을 봐야 합니다.
		}
		if (uploadService.isImgFile(file) == false) {
			return "이미지 파일만 입력 가능합니다";
		}
		String realPath = request.getSession().getServletContext()
				.getRealPath("/");
		realPath += "/userImg/";

		FileUpload upload = uploadService.fileSetting(file, realPath);

		user.setFileName(upload.getName());
		userService.insertUser(user);

		// 다음 페이지를 위한 작업
		model.addAttribute(user);
		session.setAttribute("user",
				userService.selectUserByEmail(user.getEmail()));
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

}
