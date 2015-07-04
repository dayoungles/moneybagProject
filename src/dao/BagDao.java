package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Bag;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

@Repository
public class BagDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory.getLogger(BagDao.class);

	private RowMapper<Bag> bagMapper = new RowMapper<Bag>() {
		@Override
		public Bag mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bag bag = new Bag();
			bag.setAccount(rs.getString("account"));
			bag.setAdminId(rs.getInt("admin"));
			bag.setCreatedDate(rs.getString("createdDate"));// timestamp종류는 뭘로
															// 가지고 올지?
			bag.setId(rs.getInt("moneybagId"));
			bag.setInfo(rs.getString("info"));
			bag.setPicture(rs.getString("fileName"));
			return bag;
		};

	};

	/**
	 * 백을 최초 생성하는 함수, 생성하는 유저의 계좌를 사용.
	 * 
	 * @param user
	 */
	public void createBag(User user) {
		String sql = "insert into moneybag (userId, account) values (?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getAccount());
	}

	/**
	 * 사용자 아이디를 이용해서 한 사용자가 등록되어 있는 머니백을 모두 받아 오는 것.
	 * 
	 * @param userId
	 * @return
	 */
	public List<Bag> getEnrolledMoneybag(int userId) {
		String sql = "select * from moneybag join user_moneybag_mapping on moneybag.moneybagId = user_moneybag_mapping.moneybagId where user_moneybag_mapping.userId=?";
		try {
			return jdbcTemplate.query(sql, new Object[] { userId }, bagMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public void insertBag(User user, String info) {
		String sql = "insert into moneybag (admin, account, info) values(?,?,?)";
		jdbcTemplate.update(sql, user.getId(), user.getAccount(), info);
	}

	public Bag findBagByUserIdAndBagInfo(int adminId, String bagInfo) {
		String sql = "select * from moneybag where admin=? and info=?";
		try {
			return jdbcTemplate.queryForObject(sql, new Object[] { adminId,
					bagInfo }, bagMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	public Bag findBagByBagId(int bagId) {
		String sql = "select * from moneybag where moneybagId=?";
		logger.debug("sql:{}, bagId:{}", sql, bagId);
		try {
			Bag bag = jdbcTemplate.queryForObject(sql, new Object[] { bagId },
					bagMapper);
			logger.debug("bag:{}", bag);
			return bag;
			// return jdbcTemplate.queryForObject(sql, new
			// BeanPropertyRowMapper<Bag>(Bag.class), bagId);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}
