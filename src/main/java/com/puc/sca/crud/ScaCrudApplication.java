package com.puc.sca.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


/**
 * SpringFox é um plugin que implementa a especificação do Swagger 2 e permite que 
 * a documentação seja atualizada de forma automática após qualquer modificação na API.
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
public class ScaCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScaCrudApplication.class, args);
	}

}
