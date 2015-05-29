package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import service.RoundService;

@Controller
public class RoundController {

	@Autowired
	RoundService roundService;
	
	@RequestMapping("")
	public String createForm(){
		
		return "roundForm";
	}
}
