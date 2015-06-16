package service;

import model.Bag;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.EnrollmentDao;

@Service
public class EnrollmentService {

	@Autowired
	EnrollmentDao enrollDao;

	public void enrollUser(int userId, int bagId) {
		enrollDao.enrollUser(userId, bagId);
	}

	public void removeEnroll(User user, Bag bag) {
		enrollDao.removeEnroll(user.getId(), bag.getId());
	}

}
