package controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/applicationContext.xml")
public class SignupControllerTest {
//	@Autowired
//	UserDao userDao;

	@Test
	public void testCreateUser() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(
				"controller.signupcontroller");
		SignupController sc = ctx.getBean("signupController",
				SignupController.class);
	}

}
