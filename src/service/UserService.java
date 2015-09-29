package service;

import java.util.List;

import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import controller.NotExistException;
import dao.UserDao;
import dao.UserMappingDao;
import exception.ValidException;

@Service
public class UserService {

	private static final Logger logger = LoggerFactory.getLogger(UserService.class);
	@Autowired
	private UserDao userDao;

	@Autowired
	UserMappingDao userMappingDao;

	public void insertUser(User user) throws Exception {
		// 이미 가입된 email인지 확인
		if (isExistUser(user.getEmail())) {
			throw new Exception("이미 가입된 유저 메일. 가입 반려 ");
		}
		userDao.createUser(user);
	}

	public void insertUser(User user, String account) throws Exception {
		if (getUserJoinedByFacebook(user.getFacebookId()) != null) {
			throw new Exception("이미 가입된 유저 메일. 가입 반려 ");
		}
		user.setAccount(account);
		userDao.createUserWithFacebookId(user);
	}

	public boolean isExistUser(String email) throws NotExistException {
		User resultUser = userDao.getUserByEmail(email);
		if (resultUser == null) {
			throw new NotExistException("사용자가 존재하지 않습니다.");
		}
		return true;
	}

	public User selectUserByEmail(String email) {
		User resultUser = userDao.getUserByEmail(email);
		return resultUser;
	}

	public User checkLoginValidation(User user) throws Exception {
		// user정보가 있는지 확인-> isExistUser()
		if (!isExistUser(user.getEmail())) {
			throw new NotExistException("가입된 유저가 아니라고 ");
		} else {
			User foundUser = selectUserByEmail(user.getEmail());
			if (!foundUser.getPassword().equals(user.getPassword())) {
				throw new ValidException("비번이 안 맞아 난 비번을 생으로 가지고 있거든.");
			}
			return foundUser;
		}
	}

	public boolean isExistUserByName(String name) {
		User foundUser = userDao.getUserByName(name);
		if (foundUser != null)
			return true;
		return false;
	}

	public List getMembersInBag(int bagId) {
		return userDao.getBagMembers(bagId);
	}

	public User getUserByUserId(int userId) {
		return userDao.getUserByUserId(userId);
	}

	public User getUserJoinedByFacebook(String fId) {
		return userDao.getUserByFId(fId);

	}

	public void checkSignupValidation(BindingResult result) throws ValidException {
		// validation 에러 발생 시
		if (result.hasErrors()) {
			logger.info(" 유효성 에러 ");
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				logger.debug("error:{}", error.getDefaultMessage());
			}
			throw new ValidException("validation exception ");
		}
	}

}
