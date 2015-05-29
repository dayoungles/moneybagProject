package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.PostConstruct;

import model.Bag;
import model.Round;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class RoundDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(RoundDao.class);

	private RowMapper<Round> roundMapper = new RowMapper<Round>() {
		@Override
		public Round mapRow(ResultSet rs, int rowNum) throws SQLException {
			Round round = new Round();
			round.setRoundId(rs.getInt("roundId"));
			round.setCreatedDate(rs.getString("createdDate"));
			round.setInfo(rs.getString("info"));
			round.setnBang(rs.getBoolean("nBang"));
			round.setTotal(rs.getInt("total"));
			return round;
		};
		
	};

	public List<Round> findAllRoundByBagId(int bagId) {
		String sql ="select * from round where moneybagId=?";
		try{
			return jdbcTemplate.query(sql, new Object[]{bagId}, this.roundMapper);
		}catch(EmptyResultDataAccessException e){
			return null;
		}

	}
	public void createRound(Round round, User user) {
		String sql = "insert into round (moneybagId, roundAdminId, total, info, nBang) values (?,?,?,?,?) ";
		jdbcTemplate.update(sql, round.getMoneybagId(), user.getId(), round.getTotal(), round.getInfo(), round.isnBang());
		logger.debug("input round");
	}
	
	
}
