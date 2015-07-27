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
		
		return "/bag/payCheck";
	}

}
