package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Board;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping("/list/{bagId}")
	public String showBoard(@PathVariable("bagId") int bagId, Model model){
		List boardList = boardService.getBoardList(bagId);
		logger.debug("boardList:{}", boardList);
		model.addAttribute("boardList", boardList);
		model.addAttribute("bagId", bagId);
		return "/board/boardList";
	}
	
	@RequestMapping("/writePage/{bagId}")
	public String showWrite(@PathVariable("bagId") int bagId, Model model, HttpSession session){
		User user = (User) session.getAttribute("user");
		model.addAttribute("userId", user.getId());
		model.addAttribute("moneybagId", bagId);
		return "/board/writeForm";
	}
	
	@RequestMapping("/writing")
	public String writing(Board board){
		boardService.writeBoard(board);
		return "redirect:/board/list/"+board.getMoneybagId();
	}
	
	
}
