package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Bag;
import model.Round;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.BagService;
import service.EnrollmentService;
import service.RoundService;
import service.UserService;

@Controller
public class BagController {

	private static final Logger logger = LoggerFactory
			.getLogger(BagController.class);
	@Autowired
	BagService bagService;

	@Autowired
	EnrollmentService enrollService;

	@Autowired
	UserService userService;

	@Autowired
	RoundService roundService;

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
			@RequestParam("user1") String addUserEmail, HttpSession session) {
		User user = (User) session.getAttribute("user");
		logger.debug("user:{}", user);
		// 계좌 여는 유저 정보, 만들려고 하는 머니백 이름
		bagService.createBag(user, info);
		Bag foundBag = bagService.findBagByUserIdandInfo(user.getId(), info);
		// admin등록
		enrollService.enrollUser(user.getId(), foundBag.getId());
		// 멤버 등록
		if (userService.isExistUser(addUserEmail)) {
			User addUser = userService.selectUserByEmail(addUserEmail);
			enrollService.enrollUser(addUser.getId(), foundBag.getId());
		} else {
			// 이런 부분 클라이언트에 어떻게 처리해주나? 바로 존재하는 회원인지 ajax로 확인해야 할 것 같은데.
			logger.info("등록된 유저가 아닌뎁쇼 가입하라고 메일 보내야할 듯");
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
		List<Round> roundList = roundService.findAllRoundByBagId(bagId);
		model.addAttribute("roundList", roundList);
		model.addAttribute("bag", bag);
		return "/bag/showBagInfo";
	}

	@RequestMapping("roundForm/{bagId}")
	public String createForm(Model model, @PathVariable("bagId") String bagId) {
		model.addAttribute("bagId", bagId);
		model.addAttribute("round", new Round());
		return "/bag/roundForm";
	}

	@RequestMapping("inputRound/{bagId}")
	public String createRound(@PathVariable("bagId") String bagId,
			@ModelAttribute("round") Round round, Model model,
			HttpSession session) {
		User user = (User) session.getAttribute("user");
		round.setMoneybagId(Integer.parseInt(bagId));
		roundService.createRound(round, user);
		model.addAttribute("bagId", bagId);
		return "redirect:/showBag/" + bagId;
	}

}
