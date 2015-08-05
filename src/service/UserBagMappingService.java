package service;

import model.Bag;
import model.BagMember;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMappingDao;

@Service
public class UserBagMappingService {

	@Autowired
	UserMappingDao userMappingDao;

	public void enrollUser(BagMember userIdList, int bagId) {
		userMappingDao.enrollUser(userIdList, bagId);
	}

	public void removeEnroll(User user, Bag bag) {
		userMappingDao.removeUserFromBag(user.getId(), bag.getId());
	}
	
	public String[] parseUserList(String userIdList){
		return userIdList.split(",");
		
	}

}
