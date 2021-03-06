package training.cfg;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableAspectJAutoProxy
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackages = { "training.dao", "training.web" })
public class AppConfig {
	
	// view resolver bean config
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/pages/");
		vr.setSuffix(".jsp");
		return vr;
	}
	
	// this bean is equivalent of an Aspect object
	@Bean
	public HibernateTransactionManager txMgr(SessionFactory factory) {
		return new HibernateTransactionManager(factory);
	}

	@Bean
	public LocalSessionFactoryBean factory(DataSource ds) {
		LocalSessionFactoryBean sf = new LocalSessionFactoryBean();
		sf.setDataSource(ds);
		sf.setConfigLocation(new ClassPathResource("hibernate.cfg.xml"));
		return sf;
	}

	@Bean
	public HibernateTemplate ht(SessionFactory factory) {
		return new HibernateTemplate(factory);
	}

	@Bean(name = "ds")
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

}
