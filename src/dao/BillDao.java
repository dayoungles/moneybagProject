package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Bill;
import model.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class BillDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	private static final Logger logger = LoggerFactory
			.getLogger(BillDao.class);

	private RowMapper<Bill> billMapper = new RowMapper<Bill>() {
		@Override
		public Bill mapRow(ResultSet rs, int rowNum) throws SQLException {
			Bill bill = new Bill();
			bill.setBill_id(rs.getInt("bill_id"));
			bill.setCreatedDate(rs.getString("createdDate"));
			bill.setBillName(rs.getString("billName"));
			bill.setInfo(rs.getString("info"));
			bill.setFileName(rs.getString("fileName"));
			bill.setUsedMoney(rs.getInt("usedMoney"));
			return bill;
		};

	};

	public List<Bill> findAllBillsByBagId(int bagId) {
		String sql = "select * from bill where moneybagId=?";
		try {
			return jdbcTemplate.query(sql, new Object[] { bagId },
					this.billMapper);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}

	}

	public void createBill(Bill bill, User user) {
		String sql = "insert into bill (moneybagId, billName, info, fileName, usedMoney) values (?,?,?,?,?) ";
		logger.debug("bill:{}", bill);
		jdbcTemplate.update(sql, bill.getMoneybagId(), bill.getBillName(), bill.getInfo(),bill.getFileName(),bill.getUsedMoney());
		
	}

	public Bill getBill(int bill_id) {
		String sql="select * from bill where bill_id=?";
		return jdbcTemplate.queryForObject(sql, new Object[]{bill_id}, this.billMapper);
	}

}
