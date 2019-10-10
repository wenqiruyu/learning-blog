package com.permission.demo.wen;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.permission.demo.wen.mapper")
public class PermissionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PermissionDemoApplication.class, args);
	}

}
