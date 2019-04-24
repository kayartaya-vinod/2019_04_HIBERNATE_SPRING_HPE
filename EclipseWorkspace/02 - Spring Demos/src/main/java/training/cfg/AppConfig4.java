package training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.dao.ProductDao;
import training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig4 {
	
	@Bean
	public DataSource ds() {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName("org.h2.Driver");
		bds.setUrl("jdbc:h2:tcp://localhost/~/DB20190422");
		bds.setUsername("sa");
		bds.setPassword("");
		bds.setInitialSize(10);
		bds.setMaxTotal(100);
		bds.setMaxIdle(50);
		bds.setMinIdle(5);
		return bds;
	}

	// @Bean(autowire=Autowire.BY_TYPE) // 'autowire' depricated as of 5.1
	@Bean
	public ProductDao dao(DataSource ds) { // dependency injection
		return new JdbcProductDao(ds); // manual wiring
	}

}
