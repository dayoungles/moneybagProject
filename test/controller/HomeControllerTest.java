package controller;

import static org.mockito.Mockito.verify;
import model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.ui.Model;

import service.HomeService;

@RunWith(MockitoJUnitRunner.class)
public class HomeControllerTest {
	
	@InjectMocks
	private HomeController homeController;
	
	@Mock
	private HomeService homeService;
	
	@Mock
	private MockHttpSession session;
	
	@Mock
	private Model model;
	
	@Test
	public void getBagTest() {
//		homeController.showHome(model, session);
		homeService.getEnrolledBagListById(1);
		verify(homeService).getEnrolledBagListById(1);
		session.setAttribute("User", new User());
//		정확하게 테스트 하고 싶은 것이 무엇인지 알아야 테스트 가능. 
//		session
//		when(session.getAttribute("user")).then
//		verify(session, times(1)).setAttribute("User", new User());
	}

}
