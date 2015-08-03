package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bag;
import model.Bill;
import model.FileUpload;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.BagService;
import service.UploadService;
import service.UserBagMappingService;
import service.BillService;
import service.UserService;

@Controller
public class BagController {

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
	 * @param info
	 *            머니백 이름
	 * @param addUserEmail
	 *            추가하려고 하는 유저 이메일을 받기로 했음. 그런데 이거 추가하는 방법도 유동적으로 바꿀 예정.
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "/createBag", method = RequestMethod.POST)
	public String createBag(@RequestParam("info") String info,
			@RequestParam("userList") String userIdList,
			@RequestParam("file") MultipartFile file, 
			HttpSession session,
			HttpServletRequest request) {
		User user = (User) session.getAttribute("user");

		Bag bag = new Bag(user.getId(), user.getAccount(), info);
		// 계좌 여는 유저 정보, 만들려고 하는 머니백 이름
		int bagId = bagService.createBag(bag);
		Bag foundBag = bagService.findBagByBagId(bagId);

		if (uploadService.isImgFile(file) == false) {
			return "이미지 파일만 입력 가능합니다";
		}

		String realPath = request.getSession().getServletContext()
				.getRealPath("/");
		realPath += "/bagImg/";
		FileUpload upload = uploadService.fileSetting(file, realPath);
		// 사진 등록 로직 정리할 것
		bagService.setImgFileName(upload.getName(), bagId);

		// admin등록
		enrollService.enrollUser(user.getId(), foundBag.getId());
		// 멤버 등록
		// userIdList를 파싱해서 배열로 만든다.
		String[] userIds = userIdList.split(",");
		// 각 배열에 대해서 enrolluser를 한번씩 해준다. 과부하라고 생각하지만 인원이 늘 유동적이기 때문에 방법이 없는 것
		// 같다.
		int length = userIds.length;
		
		for (int i = 0; i < length; i++) {
			enrollService.enrollUser(Integer.parseInt(userIds[i]), bagId);
		}
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
