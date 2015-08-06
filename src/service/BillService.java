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
	BillDao billDao;

	public List<Bill> findAllBillsByBagId(int bagId) {
		return billDao.findAllBillsByBagId(bagId);
	}

	public void createBill(Bill bill, User user) {
		billDao.createBill(bill, user);
	}

	public Bill getBillByBill_id(int bill_id) {
		return billDao.getBill(bill_id);
	}

}
