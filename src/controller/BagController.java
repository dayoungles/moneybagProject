package controller;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bag;
import model.BagMember;
import model.Bill;
import model.FileUpload;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.BagService;
import service.BillService;
import service.UploadService;
import service.UserBagMappingService;
import service.UserService;

@Controller
public class BagController {
	final String imgFolder="bagImg/";
	
	private static final Logger logger = LoggerFactory
			.getLogger(BagController.class);
	@Autowired
	BagService bagService;

	@Autowired
	private UploadService uploadService;
	@Autowired
	UserBagMappingService enrollService;

	@Autowired
	UserService userService;

	@Autowired
	BillService billService;

	@RequestMapping("/moneybagForm")
	public String moneybagForm() {
		return "/bag/bagForm";
	}

	/**
	 * 머니백 생성할 때 쓰는 함수. createForm에서 온다.
	 * 
	 * @param info: 머니백 이름  
	 * @param userIdList: 추가하려고 하는 유저들의 userId (형식: "1, 23,123") 
	 * @param session
	 * @param 
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping(value = "/createBag", method = RequestMethod.POST)
	public String createBag(@RequestParam("info") String info,
			@RequestParam("userList") String userIdList,
			@RequestParam("file") MultipartFile file, 
			HttpSession session,
			HttpServletRequest request) throws Exception {
		//user session get
		User user = (User) session.getAttribute("user");
//		ServletContext sc = request.getServletContext();
		//file upload
		FileUpload upload = uploadService.uploadFile(file, this.imgFolder);
		//make bag
		Bag bag = new Bag(user.getId(), user.getAccount(), info, upload.getName());
		Bag foundBag = bagService.createBag(bag);
		// enroll members
		enrollService.enrollUser(new BagMember(userIdList, user.getId()),foundBag.getId());
		return "redirect:/index";
	}

	/**
	 * home.jsp에서 bag을 선택하면 상세 페이지로 이동
	 * 
	 * @param bagId
	 * @param session
	 * @param model
	 * @return
	 */
	@RequestMapping("/showBag/{bagId}")
	public String showBag(@PathVariable("bagId") int bagId,
			HttpSession session, Model model) {
		Bag bag = bagService.findBagByBagId(bagId);
		List<Bill> billList = billService.findAllBillsByBagId(bagId);
		logger.debug("bag:{}", bag);
		model.addAttribute("billList", billList);
		model.addAttribute("bag", bag);
		return "/bag/showBagInfo";
	}

}
