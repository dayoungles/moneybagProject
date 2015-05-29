package service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserDao;
import model.User;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

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
		//user정보가 있는지 확인-> isExistUser()
		if(!isExistUser(user.getEmail())){
			return null;
		}else{
			User foundUser = selectUserByEmail(user.getEmail());
			if(!foundUser.getPassword().equals(user.getPassword())){
				return null;
			}
			return foundUser;
		}
	}

}
