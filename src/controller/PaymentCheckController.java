package controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PaymentCheckController {
	private static final Logger logger = LoggerFactory
			.getLogger(PaymentCheckController.class);
	
	@RequestMapping("/moneybagPayCheck/{bagId}")
	public String moneybagPayCheck(Model model, @PathVariable("bagId") String bagId) {
/*
 * 필요한 내용
 * 1. moneyBag title
 * 2. 지불정보(날짜, 사용자명단, 각각의 payment상태값[불참, 납부, 미납])
 * 
 * */
		model.addAttribute("bagId", bagId);//다른 작업하는데 쓰려고 일단 내가 붙여둠-다영글;
		return "/bag/payCheck";
	}

}
