package training.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import training.dao.DaoException;
import training.dao.ProductDao;

@Repository 
// @Controller or @RestController or @Service or @Repository or @Configuration
public class JdbcProductDao implements ProductDao {

	// parameters for a new connection
	private String driverClassName;
	private String url;
	private String username;
	private String password;

	// ready-to-use connection
	private Connection connection;

	// connection pool
	@Autowired
	@Qualifier("ds")
	private DataSource dataSource;
	
	// considered as a good practice
	public JdbcProductDao() {
	}
	
	public JdbcProductDao(String driverClassName, String url, String username, String password) {
		this.driverClassName = driverClassName;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	
	public JdbcProductDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	// writable property "driverClassName" (a.k.a mutator or setter property)
	// spring can inject a dependency via this setter.
	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void setDataSource(DataSource dataSource) {
		System.out.println("setDataSource(..) was called.");
		this.dataSource = dataSource;
	}

	private Connection openConnection() throws Exception {
		if (dataSource != null) {
			return dataSource.getConnection();
		}
		if (connection != null && connection.isClosed() == false) {
			return connection;
		}
		Class.forName(driverClassName);
		return DriverManager.getConnection(url, username, password);
	}

	@Override
	public int count() throws DaoException {
		String sql = "select count(*) from products";
		try(
			Connection conn = openConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
		) {
			rs.next();
			return rs.getInt(1);
		}
		catch(Exception rootCause) {
			// exception funneling; convert the root cause into a custom exception
			throw new DaoException(rootCause);
		}
	}

}







