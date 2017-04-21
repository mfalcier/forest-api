package org.mfalcier.forest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Spring Boot application main class
 * 
 * @author marcofalcier
 *
 */
@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "org.mfalcier.forest.api.domain")
public class ForestApiApplication {
	public static void main(String[] args) {
		SpringApplication.run(ForestApiApplication.class, args);
	}
}
