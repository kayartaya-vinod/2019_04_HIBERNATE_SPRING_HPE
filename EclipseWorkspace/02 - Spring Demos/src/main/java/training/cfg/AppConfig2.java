package training.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import training.dao.ProductDao;
import training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig2 {

	@Scope("singleton")
	@Bean(name = { "jdbc", "dao", "jdbcDao" })
	public ProductDao jdbc() {
		System.out.println("jdbc() function called!");
		JdbcProductDao dao = new JdbcProductDao();
		// manual dependency injection via setters
		dao.setDriverClassName("org.h2.Driver");
		dao.setUsername("sa");
		dao.setPassword("");
		dao.setUrl("jdbc:h2:tcp://localhost/~/DB20190422");
		return dao;
	}
}
