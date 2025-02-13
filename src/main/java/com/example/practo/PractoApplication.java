package com.example.practo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.practo")
public class PractoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PractoApplication.class, args);
	}

}
