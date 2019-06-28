package com.puc.sca.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.puc.sca.entity")
@ComponentScan("com.puc.sca.controller")
@EnableJpaRepositories("com.puc.sca.repository")
public class ScaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaCrudApplication.class, args);
	}

}
