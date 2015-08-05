package service;

import model.Bag;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BagDao;

@Service
public class BagService {

	@Autowired
	BagDao bagDao;

	public Bag createBag(Bag bag) {
		return  bagDao.insertBag(bag);
	}

	public Bag findBagByBagId(int bagId) {
		return bagDao.findBagByBagId(bagId);
	}

}
