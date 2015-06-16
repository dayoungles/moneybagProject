package controller;

import javax.servlet.http.HttpSession;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;
import dao.UserDao;

@Controller
@RequestMapping("/signup")
public class SignupController {

	private static final Logger logger = LoggerFactory
			.getLogger(SignupController.class);

	@Autowired
	private UserService userService;

	@RequestMapping("form")
	public String signupForm(Model model) {
		model.addAttribute(new User());
		return "/user/signup";
	}

	/*
	 * User의 정보를 받아서 그 user를 db에 삽입
	 * 
	 * @return String "index"
	 */
	@RequestMapping("insert")
	public String createUser(@ModelAttribute("user") User user, Model model,
			HttpSession session) {
		userService.insertUser(user);
		session.setAttribute("user",
				userService.selectUserByEmail(user.getEmail()));
		return "redirect:/index";
	}

}
