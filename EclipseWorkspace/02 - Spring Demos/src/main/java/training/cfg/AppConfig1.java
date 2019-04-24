package training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.dao.ProductDao;
import training.dao.impl.DummyProductDao;
import training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig1 {
	
	public AppConfig1() {
		System.out.println("creating an object of AppConfig1...");
	}

	@Bean
	public ProductDao dummy() {
		System.out.println("returning an instanceof DummyProductDao...");
		return new DummyProductDao();
	}
	
	@Bean
	public ProductDao jdbc() {
		System.out.println("returning an instanceof JdbcProductDao...");
		return new JdbcProductDao();
	}
}
