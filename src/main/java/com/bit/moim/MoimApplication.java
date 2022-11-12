package com.bit.moim;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@Configuration
@ComponentScan({"data.*"})
@MapperScan({"data.*"})
public class MoimApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoimApplication.class, args);
	}

}
