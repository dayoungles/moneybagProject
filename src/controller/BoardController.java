package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import model.Board;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import service.BoardService;
import service.UserService;

@Controller
@RequestMapping("/board")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	BoardService boardService;
	
	@Autowired
	UserService userService;
	
	@RequestMapping("/list/{bagId}")
	public String showBoardList(@PathVariable("bagId") int bagId, Model model){
		List boardList = boardService.getBoardList(bagId);
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
	
	@RequestMapping("/showBoard/{boardId}")
	public String showBoard(@PathVariable("boardId") int boardId, Model model){
		Board board = boardService.getBoardByBoardId(boardId);
		User user = userService.getUserByUserId(board.getWriterId());
		model.addAttribute("user", user);
		model.addAttribute("board", board);
		model.addAttribute("bagId", board.getMoneybagId());
		return "/board/showBoard";
	}
	
}
