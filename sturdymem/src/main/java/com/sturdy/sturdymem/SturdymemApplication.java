package com.sturdy.sturdymem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.sturdy.sturdymem.dao")
public class SturdymemApplication {

	public static void main(String[] args) {
		SpringApplication.run(SturdymemApplication.class, args);
	}

}
