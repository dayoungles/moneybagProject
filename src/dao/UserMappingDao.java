package dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class UserMappingDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void enrollUser(int userId, int bagId) {
		String sql = "insert into user_moneybag_mapping(userId, moneybagId) values (?,?)";
		jdbcTemplate.update(sql, userId, bagId);
	}

	public void removeUserFromBag(int userId, int bagId) {
		String sql = "delete from user_moneybag_mapping where userId =? and moneybagId=?";
		jdbcTemplate.update(sql, userId, bagId);
	}

}
