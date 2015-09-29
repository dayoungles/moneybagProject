package controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpSession;

import model.Bag;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import service.HomeService;

@Controller
public class HomeController {
	@Autowired
	HomeService homeService;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@RequestMapping("index")
	public String showHome(Model model, HttpSession session) throws UnsupportedEncodingException {
		User user = (User) session.getAttribute("user");
		List<Bag> bagList = homeService.getEnrolledBagListById(user.getId());
		model.addAttribute("bagList", bagList);
		return "/user/home";
	}

	@RequestMapping("/testAjax")
	public String showTest() {
		return "testAjax";
	}
	
	@RequestMapping("errorPage/{message}")
	public String errorAhead(Model model, @PathVariable String message){
		model.addAttribute("message", message);
		return "/errorPage";
	}
	
}
