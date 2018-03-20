package com.demos.integration.spidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dataSources.xml")
public class SpidemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpidemoApplication.class, args);
	}
}
