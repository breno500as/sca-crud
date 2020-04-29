package com.puc.sca.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * springdoc-openapi-ui é uma dependência que pode ser adicionada no projeto para gerar
 * a documentação utilizando o padrão OpenAPI 3 e o Swagger
 * 
 * 1 - Configurar as dependências requeridas do plugin spring open api no pom.xml
 * 2 - Acessar a url da documentação: http://127.0.0.1:8081/crud/swagger-ui.html
 * json: http://127.0.0.1:8081/crud/v3/api-docs
 * 
 * @author Breno
 *
 */

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableCaching
public class ScaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaCrudApplication.class, args);
	}

}
