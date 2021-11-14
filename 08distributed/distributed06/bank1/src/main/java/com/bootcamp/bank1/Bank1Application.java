package com.bootcamp.bank1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bootcamp.bank1.mapper")
public class Bank1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bank1Application.class, args);
	}

}
