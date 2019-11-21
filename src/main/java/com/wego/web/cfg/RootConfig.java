package com.wego.web.cfg;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan(basePackages= {"com.wego.web"})
@Import({
	ServletConfig.class, MyBatisConfig.class, 
})
public class RootConfig {
	
	@Bean
	public DataSource dataSource() {
		
		  DriverManagerDataSource dataSource = new DriverManagerDataSource();

		  	dataSource.setDriverClassName("org.mariadb.jdbc.Driver");
		    dataSource.setUrl("jdbc:mariadb://localhost/wegodb");
		    dataSource.setUsername("wego");
		    dataSource.setPassword("wego");

		    return dataSource;
	}
	@Bean
	public DataSourceTransactionManager txManager() {
		return new DataSourceTransactionManager(dataSource());
	}
	
}
