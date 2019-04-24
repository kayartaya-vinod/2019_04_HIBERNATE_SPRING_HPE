package training.cfg;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import training.dao.ProductDao;
import training.dao.impl.JdbcProductDao;

@Configuration
public class AppConfig3 {

	@Bean(name= {"h2"})
	public Connection h2Conn() throws Exception{
		Class.forName("org.h2.Driver");
		return DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/DB20190422", "sa", "");
	}
	
	@Bean
	public Connection mysqlConn() throws Exception{
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost/northwind", "root", "Welcome#123");
	}	
	@Bean
	public ProductDao dao(@Qualifier("h2") Connection connection) { // dependency injection
		JdbcProductDao d = new JdbcProductDao();
		d.setConnection(connection); // wiring, manual.
		return d;
	}

	// @Bean
	public ProductDao jdbc() {
		// constructor injection
		return new JdbcProductDao("org.h2.Driver", 
				"jdbc:h2:tcp://localhost/~/DB20190422", "sa", "");
	}
}
