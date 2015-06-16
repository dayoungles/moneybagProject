package service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import model.Bag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import dao.BagDao;

@RunWith(MockitoJUnitRunner.class)
public class HomeServiceTest {

	@InjectMocks
	private HomeService homeService;

	@Mock
	private BagDao bagDao;

	@Test
	public void testGetEnrolledMoneybag() {
		Bag bag = new Bag();
		List<Bag> result = bagDao.getEnrolledMoneybag(1);
		System.out.println(result);
		assertThat(homeService.getEnrolledBagListById(1), equalTo(result));
	}

}
