package com.shopx.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@ComponentScan(basePackages = "com.shopx.*")
@EnableTransactionManagement
public class DbConfig {
	
	private String sql = "com.mysql.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/shopx";
	private String name = "root";
	private String pass = "root";
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() 
	{
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/shopx");

		dataSource.setUsername("root");
		dataSource.setPassword("root");
		System.out.println("DataSource - "+dataSource);
		return dataSource;
	}
	
	  private Properties getHibernateProperties() {
	    	Properties properties = new Properties();
	    	properties.put("hibernate.show_sql", "true");
	    	properties.put("hibernate.hbm2ddl.auto", "update");
	    	properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
	    	System.out.println("Properties - "+properties);
	    	return properties;
	    }
	 
	   @Bean (name = "sessionFactory")
	   @Autowired
	   public LocalSessionFactoryBean getSessionFactory() 
	   {
	      LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
	      sessionFactory.setDataSource(getDataSource());
	      sessionFactory.setPackagesToScan("com.shopx.model");
	      sessionFactory.setHibernateProperties(getHibernateProperties());	 
	      System.out.println("LocalSessionFactoryBean - "+sessionFactory);
	      return sessionFactory;
	   }
	   
	    @Bean(name = "transactionManager")
			@Autowired
			public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
				HibernateTransactionManager transactionManager = new HibernateTransactionManager(
						sessionFactory);
				System.out.println("HibernateTransactionManager - "+transactionManager);
				return transactionManager;
			}
	
}
