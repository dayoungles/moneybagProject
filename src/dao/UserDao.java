package dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.PostConstruct;

import model.User;

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
// public class UserDao extends JdbcDaoSupport{
public class UserDao {
	@Autowired
	JdbcTemplate jdbctemplate;

	private RowMapper<User> userMapper = new RowMapper<User>() {

		@Override
		public User mapRow(ResultSet rs, int i) throws SQLException {
			User user = new User();
			user.setEmail(rs.getString("email"));
			user.setName(rs.getString("name"));
			user.setPassword(rs.getString("pw"));
			user.setId(rs.getInt("userId"));
			user.setAccount(rs.getString("account"));
			return user;
		}

	};

	public void createUser(User user) {
		String sql = "INSERT INTO user (email, pw, name) values (?,?,?);";
		jdbctemplate.update(sql, user.getEmail(), user.getPassword(),
				user.getName());
	}

	public User getUserByEmail(String email) {
		String sql = "SELECT * FROM user where email =?";
		try {
			return this.jdbctemplate.queryForObject(sql,
					new Object[] { email }, this.userMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

		// User uss = (User) jdbctemplate.query(sql, new Object[]{email}, new
		// BeanPropertyRowMapper<User>(User.class));
		// try {
		// return (User) jdbctemplate.query(sql, new
		// BeanPropertyRowMapper<User>(User.class), email);
		// } catch (EmptyResultDataAccessException e) {
		// return null;
		// }
		// return null;
	}

}
