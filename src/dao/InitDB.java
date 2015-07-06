package dao;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Repository;

@Repository
public class InitDB {

	@Autowired
	JdbcTemplate jdbcTemplate;

	// 이거 중복제거 하는 법은 어디서? xml설정하면 될 것 같긴 하지만서도...
	@PostConstruct
	public void initialize() {
		ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

		populator.addScript(new ClassPathResource("moneybag0704.sql"));
		
		//샘플 코드 
		//populator.addScript(new ClassPathResource("sample.sql"));

		// DatabasePopulatorUtils.execute(populator,
		// this.jdbctemplate.getDataSource());
		DatabasePopulatorUtils.execute(populator, jdbcTemplate.getDataSource());
	}
}
