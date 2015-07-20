package service;

import java.util.List;

import model.Bill;
import model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.BillDao;

@Service
public class BillService {

	@Autowired
	BillDao roundDao;

	public List<Bill> findAllBillsByBagId(int bagId) {
		return roundDao.findAllBillsByBagId(bagId);
	}

	public void createBill(Bill bill, User user) {
		roundDao.createBill(bill, user);
	}

}
