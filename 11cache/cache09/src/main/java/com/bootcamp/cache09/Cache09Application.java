package com.bootcamp.cache09;

import com.bootcamp.cache09.entity.BsOrder;
import com.bootcamp.cache09.mapper.BsOrderMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.bootcamp.cache09.mapper")
public class Cache09Application {

	public static void main(String[] args) {
		SpringApplication.run(Cache09Application.class, args);
	}

}
