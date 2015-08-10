package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	RowMapper<Board> boardMapper = new RowMapper<Board>() {
		@Override
		public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
			Board board= new Board();
			board.setBoardId(rs.getInt("boardId"));
			board.setContent(rs.getString("content"));
			board.setTime(rs.getString("time"));
			board.setMoneybagId(rs.getInt("moneybagId"));
			board.setTitle(rs.getString("title"));
			board.setWriterId(rs.getInt("writer"));
			board.setHits(rs.getInt("hits"));
			return board;
		};
	};
	
	public void insertBoard(Board board) {
		String sql="INSERT INTO board (moneybagId, writer, title, content)  VALUE(?,?,?,?)";
		jdbcTemplate.update(sql, board.getMoneybagId(), board.getWriterId(), board.getTitle(), board.getContent());
	}

	public List getBoardListByBagId(int bagId) {
		String sql = "SELECT * from board where moneybagId=?";
		try{
			return jdbcTemplate.queryForList(sql,new Object[]{bagId});
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}

	public Board getBoard(int boardId) {
		String sql ="SELECT * FROM board WHERE boardId=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{boardId}, boardMapper);
	}
}
