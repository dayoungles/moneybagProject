package dao;

import model.BagMember;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserMappingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void enrollUser(BagMember userList, int bagId) {
		String sql = "insert into user_moneybag_mapping(userId, moneybagId) values (?,?)";

		for(int i = 0; i < userList.getMemberNum();i++){
			jdbcTemplate.update(sql,userList.getUserIds()[i] , bagId);
		}
	}

	public void removeUserFromBag(int userId, int bagId) {
		String sql = "delete from user_moneybag_mapping where userId =? and moneybagId=?";
		jdbcTemplate.update(sql, userId, bagId);
	}

}
