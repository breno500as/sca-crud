package com.puc.sca.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = {"com.puc.sca.entity"}) 
public class ScaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaCrudApplication.class, args);
	}

}
