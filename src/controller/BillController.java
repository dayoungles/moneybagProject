package controller;


import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import model.Bill;
import model.FileUpload;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import service.BillService;
import service.UploadService;

@Controller
@RequestMapping("bill")
public class BillController {
	private final String imgFolder = "bill_img/";
	
	@Autowired
	BillService billService;
	
	@Autowired
	UploadService uploadService;
	
	@RequestMapping("/form/{bagId}")
	public String createForm(Model model, @PathVariable("bagId") String bagId) {
		model.addAttribute("bagId", bagId);
		return "/bag/billForm";
	}

	@RequestMapping("create/{bagId}")
	public String createRound(@PathVariable("bagId") String bagId,
			@RequestParam("file") MultipartFile file, Bill bill,
			HttpServletRequest request, HttpSession session) throws Exception {
		
		User user = (User) session.getAttribute("user");
//		Bill bill = new Bill(billName, usedMoney, info, Integer.parseInt(bagId));
		
		FileUpload upload = uploadService.uploadFile(file, this.imgFolder);
		bill.setFileName(upload.getName());
		bill.setMoneybagId(Integer.parseInt(bagId));
		
		billService.createBill(bill, user);//uuid 파일 이름
		return "redirect:/showBag/" + bagId;
	}
	
}