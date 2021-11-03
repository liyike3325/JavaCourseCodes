package com.bootcamp.db09;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@SpringBootApplication
public class Db09Application {

	public static void main(String[] args) {
		SpringApplication.run(Db09Application.class, args);
	}

	@Bean
	@Primary
	@ConfigurationProperties(prefix = "jdbc.datasource")
	public DataSource primaryDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean(name = "secondDatasource")
	@ConfigurationProperties(prefix = "jdbc.second-datasource")
	public DataSource secondDataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	@Primary
	public JdbcTemplate primaryJdbcTemplate(DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}

	@Bean(name = "secondJdbcTemplate")
	public JdbcTemplate secondJdbcTemplate(@Qualifier("secondDatasource") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
	}
}
