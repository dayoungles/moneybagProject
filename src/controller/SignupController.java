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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import service.UserService;

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
			HttpSession session, FileUpload upload) {
		
		if(upload.getFile() == null || upload.getFile().getSize() == 0){
			upload.setName(0);
		} else {
			upload.setName(user.getId());
		}
		File file = new File("/userImg/"+ upload.getName());
		
		try {
			upload.getFile().transferTo(file);
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		user.setFileName(upload.getName());
		userService.insertUser(user);
		session.setAttribute("user",
				userService.selectUserByEmail(user.getEmail()));
		return "redirect:/index";
	}

}
