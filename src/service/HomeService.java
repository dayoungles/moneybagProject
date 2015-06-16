package service;

import java.util.List;
import java.util.Map;

import model.Bag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BagDao;

@Service
public class HomeService {

	@Autowired
	BagDao bagDao;

	private static final Logger logger = LoggerFactory
			.getLogger(HomeService.class);

	public List<Bag> getEnrolledBagListById(int userId) {
		List<Bag> bagList = bagDao.getEnrolledMoneybag(userId);
		return bagList;
	}
}
