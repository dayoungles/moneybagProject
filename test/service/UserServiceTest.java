package service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import dao.UserDao;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	List<String> test = new ArrayList<String>();
	@Mock
	private UserDao userDao;

	@Test
	public void testCreate() {
		User user = new User();
		// int result = 100;
		// when(userDao.get()).thenReturn(10);
		//
		userService.insertUser(user);

		verify(userDao, times(1)).createUser(user);

		// assertThat(userService.insertUser(user), equalTo(result));
		// assertThat(expectedArticleComment.getArticleId(),
		// equalTo(Integer.parseInt(STR_ARTICLE_ID)));
		// assertThat(expectedArticleComment.getUserId(), equalTo(STR_USER_ID));
		// assertThat(expectedArticleComment.getContent(), equalTo(CONTENT));
	}

	@Test
	public void testIsExistUser() {
		User user = new User("test", "name", "pw", "account");
		boolean result = userService.isExistUser(user.getEmail());
		assertEquals(false, result);
	}

}
