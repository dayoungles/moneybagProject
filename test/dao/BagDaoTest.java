package dao;
import static org.junit.Assert.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import java.util.List;

import javax.sql.DataSource;

import model.Bag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/applicationContext.xml", "file:webapp/WEB-INF/tmm-servlet.xml"})
public class BagDaoTest {
	@Autowired
	DataSource dataSource;
	
	@Autowired
	BagDao bagDao;
	
	@Test
	public void testGetEnrolledMoneybag() {
		
		List<Bag> bagList= bagDao.getEnrolledMoneybag(1);
		
		System.out.println(bagList.toString());
	}

}
