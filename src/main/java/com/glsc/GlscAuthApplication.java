package com.glsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.glsc.dao")
public class GlscAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlscAuthApplication.class, args);
	}
}
