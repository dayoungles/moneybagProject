package service;

import java.util.List;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import dao.UserMappingDao;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;
	
	@Autowired
	UserMappingDao userMappingDao;

	public void insertUser(User user) {
		// 이미 가입된 email인지 확인
		if (isExistUser(user.getEmail())) {
			logger.info("이미 가입된 유저 메일. 가입 반려. ");
			return;
		}
		userDao.createUser(user);
	}

	public boolean isExistUser(String email) {
		User resultUser = userDao.getUserByEmail(email);
		if (resultUser == null) {
			return false;
		}
		return true;
	}

	public User selectUserByEmail(String email) {
		User resultUser = userDao.getUserByEmail(email);
		return resultUser;
	}

	public User checkLoginValidation(User user) {
		// user정보가 있는지 확인-> isExistUser()
		if (!isExistUser(user.getEmail())) {
			return null;
		} else {
			User foundUser = selectUserByEmail(user.getEmail());
			if (!foundUser.getPassword().equals(user.getPassword())) {
				return null;
			}
			return foundUser;
		}
	}

	public boolean isExistUserByName(String name) {
		User foundUser= userDao.getUserByName(name);
		if(foundUser != null)
			return true;
		return false;
	}

	public List getMembersInBag(int bagId) {
		return userDao.getBagMembers(bagId);
	}

	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}


}
