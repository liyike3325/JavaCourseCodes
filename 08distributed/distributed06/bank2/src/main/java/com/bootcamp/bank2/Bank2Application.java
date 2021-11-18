package com.bootcamp.bank2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@MapperScan("com.bootcamp.bank2.mapper")
public class Bank2Application {

	public static void main(String[] args) { SpringApplication.run(Bank2Application.class, args); }

}
