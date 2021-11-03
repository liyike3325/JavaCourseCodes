package com.bootcamp.db10;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.bootcamp.db10.mapper")
public class Db10Application {

	public static void main(String[] args) {
		SpringApplication.run(Db10Application.class, args);
	}

}
