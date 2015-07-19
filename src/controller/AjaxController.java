package controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import service.UploadService;

@Controller
@RequestMapping("/api")
public class AjaxController {
	 @Autowired
	 UploadService uploadService;
	
//	 @RequestMapping("/fileUpload")
//	 public @ResponseBody String fileUploader(@RequestParam("uploadFile")
//	 MultipartFile file) throws IllegalStateException, IOException{
////	 String fileName = uploadService.storeFileToDirectory(file);
//	
//	 return fileName;
//	 }
	 
	 @RequestMapping("/test")
	 public @ResponseBody String testAjax(){
		 
		 return "test success";
	 }

	 @RequestMapping("/upload")
	 public String uploadForm(){
		 return "uploadpage";
	 }
	 
}
