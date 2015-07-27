package controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private static final Logger logger = LoggerFactory
			.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "/user/loginForm";
	}

	@RequestMapping("/loginCheck")
	public String checkLogin(@Valid @ModelAttribute("user") User user, BindingResult result,Model model,
			HttpSession session) {
		// 로그인 가능한지 확인하는 함수 사용
		
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				logger.debug("error:{}", error.getDefaultMessage());
			}
			return "redirect:/user/login";
		}
		
		logger.debug("user:{}", user);
		if (userService.checkLoginValidation(user) != null) {
			User foundUser = userService.selectUserByEmail(user.getEmail());
			session.setAttribute("user", foundUser);
			return "redirect:/index";
		}
		// 없는 정보라는게 확인되면 어떻게 알려줄꺼야? js로 답변을 주면 될지도 모르겠다. session같은 것들은 어떻게
		// 처리해야하는지 샘플을 살펴보자
		return "/user/loginForm";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/user/login";
	}

}
