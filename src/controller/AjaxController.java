package controller;

import jdk.nashorn.internal.parser.JSONParser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UploadService;

@Controller
@RequestMapping("/api")
public class AjaxController {
	

	private static final Logger logger = LoggerFactory.getLogger(AjaxController.class);
	
	@Autowired
	UploadService uploadService;

	// @RequestMapping("/fileUpload")
	// public @ResponseBody String fileUploader(@RequestParam("uploadFile")
	// MultipartFile file) throws IllegalStateException, IOException{
	// // String fileName = uploadService.storeFileToDirectory(file);
	//
	// return fileName;
	// }
	@RequestMapping(value="/test")
	public @ResponseBody String testAjax() {

		return "test succeddddddd";
	}
	
//	@RequestMapping(value="/addMember")
	@RequestMapping(value="/addMember", method=RequestMethod.POST, headers="Content-Type=application/x-www-form-urlencoded")
	public @ResponseBody String testAddmember(@RequestBody String name) {
		logger.debug(name);
		return name;
	}

	@RequestMapping("/upload")
	public String uploadForm() {
		return "uploadpage";
	}

}
