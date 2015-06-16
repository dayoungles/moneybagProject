package dao;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;

import javax.sql.DataSource;

import model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "classpath:/applicationContext.xml",
		"file:webapp/WEB-INF/tmm-servlet.xml" })
public class UserDaoTest {
	@Autowired
	DataSource datasource;
	@Autowired
	UserDao userdao;

	@Test
	public void testApplicationContextSetting() {
		// assertNotNull(datasource);
	}

	@Test
	public void testCreateUser() {
		User user = new User("email", "pass", "name", "account");

		userdao.createUser(user);
		User actual = userdao.getUserByEmail(user.getEmail());

		assertThat(actual.getEmail(), equalTo(user.getEmail()));
	}

}
