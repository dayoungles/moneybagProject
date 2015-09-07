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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

	/**
	 * 유저 정보 validation 체크 한 후 로그인 실행 
	 * @param user
	 * @param result
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/loginCheck")
	public String checkLogin(@Valid @ModelAttribute("user") User user, BindingResult result,Model model,
			HttpSession session) throws Exception {
		//user가 기입한 validation체크 
		if(result.hasErrors()){
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				logger.debug("error:{}", error.getDefaultMessage());
			}
			return "redirect:/user/login";
		}

		User foundUser = userService.checkLoginValidation(user);
		if(foundUser != null){
			session.setAttribute("user", foundUser);
			return "redirect:/index";
		}
		return "/user/loginForm";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/user/login";
	}
	/**
	 * 머니백 하나에 소속된 멤버들을 보여줌 
	 * @param bagId
	 * @param model
	 * @return
	 */
	@RequestMapping("/showMembers/{bagId}")
	public String showMembers(@PathVariable ("bagId") int bagId, Model model){
		List members =userService.getMembersInBag(bagId);
		model.addAttribute("memberList", members);
		logger.debug("members:{}", members);
		return "/bag/showMembers";
	}
	
	/**
	 * facebook으로 로그인 하는 사람들 체크 
	 * @param fId
	 * @param fName
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/fbLogin")
	public String checkFacebookLogin(String fId, String fName, HttpSession session, Model model){
		User foundUser = userService.getUserJoinedByFacebook(fId);
		if(foundUser != null){
			session.setAttribute("user", foundUser);
			return "redirect:/index";
		} else {
			User user = new User(fId, fName);
			model.addAttribute("user", user);
			return "/signup/fbAccount";
		}
	}
}
