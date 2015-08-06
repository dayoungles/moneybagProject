package service;

import java.util.List;

import model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BoardDao;

@Service
public class BoardService {

	@Autowired
	BoardDao boardDao;
	
	public void writeBoard(Board board) {
		boardDao.insertBoard(board);
	}

	public List getBoardList(int bagId) {
		return boardDao.getBoardListByBagId(bagId);
	}

	public Board getBoardByBoardId(int boardId) {
		return boardDao.getBoard(boardId);
	}
	
}
