package com.glsc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@MapperScan("com.glsc.dao")
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GlscAuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(GlscAuthApplication.class, args);
	}
}
