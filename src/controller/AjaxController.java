package controller;

import javax.servlet.http.HttpSession;

import model.Bill;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.BagService;
import service.BillService;
import service.UploadService;
import service.UserService;
import email.EmailSendService;

@Controller
@RequestMapping("/api")
public class AjaxController {
	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);

	@Autowired
	BillService billService;

	@Autowired
	UploadService uploadService;

	@Autowired
	UserService userService;

	@Autowired
	EmailSendService emailSender;

	@Autowired
	BagService bagService;

	@RequestMapping(value = "/test")
	public @ResponseBody String testAjax() {

		return "test succeddddddd";
	}

	/**
	 * 이미 가입된 유저인지 확인하는 함수. 
	 * 
	 * @param name
	 * @return boolean value in String
	 */
	@RequestMapping(value = "/addMember")
	// @RequestMapping(value="/addMember", method=RequestMethod.POST)
	public @ResponseBody User testAddmember(@RequestParam("email") String email) {
		User user = null;
		try {
			if (userService.isExistUser(email)) {
				return userService.selectUserByEmail(email);
			} else {
				return null;// /여기 처리하는 부분 때문에 자바스크립트에서 반드시 에러가 날 것이야
			}
		} catch (NotExistException e) {
			// TODO Auto-generated catch block
			e.getMessage();
			return null;
		}
	}

	@RequestMapping("/upload")
	public String uploadForm() {
		return "uploadpage";
	}

	@RequestMapping("/sendEmail")
	public @ResponseBody String sendEmail(@RequestParam("email") String email, @RequestParam String msg, HttpSession session) {
		User user = (User) session.getAttribute("user");
		emailSender.sendJoinEmail(user, email, msg);
		return "success";
	}

	@RequestMapping("/showBillDetail")
	public @ResponseBody Bill showBillDetail(@RequestParam("bill_id") int bill_id) {
		Bill bill = billService.getBillByBill_id(bill_id);
		// TODO 빌에 대한 댓글도 찾아오기
		// TODO bill을 json으로 만들어서 return 해주기

		return bill;
	}
}
