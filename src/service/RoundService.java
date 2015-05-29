package service;

import java.util.List;

import model.Round;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.RoundDao;

@Service
public class RoundService {
	
	@Autowired
	RoundDao roundDao;

	public List<Round> findAllRoundByBagId(int bagId) {
		return roundDao.findAllRoundByBagId(bagId);
	}
	
	public void createRound(Round round, User user ){
		roundDao.createRound(round, user);
	}
	
	
	
}
