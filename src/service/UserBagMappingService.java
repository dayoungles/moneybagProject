package service;

import model.Bag;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMappingDao;

@Service
public class UserBagMappingService {

	@Autowired
	UserMappingDao userMappingDao;

	public void enrollUser(int userId, int bagId) {
		userMappingDao.enrollUser(userId, bagId);
	}

	public void removeEnroll(User user, Bag bag) {
		userMappingDao.removeUserFromBag(user.getId(), bag.getId());
	}

}
