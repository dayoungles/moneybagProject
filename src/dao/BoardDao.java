package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import model.Board;

@Repository
public class BoardDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertBoard(Board board) {
		String sql="INSERT INTO board (moneybagId,writer, title, content)  VALUE(?,?,?,?)";
		jdbcTemplate.update(sql, board.getMoneybagId(), board.getWriter(), board.getTitle(), board.getContent());
	}

	public List getBoardListByBagId(int bagId) {
		String sql = "SELECT title, time, writer, hits from board where moneybagId=?";
		try{
			return jdbcTemplate.queryForList(sql,new Object[]{bagId});
			
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

}
