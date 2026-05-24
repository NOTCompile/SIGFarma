package com.sigfarma.sigfarma_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SigfarmaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SigfarmaApiApplication.class, args);
		System.out.println("\n===========================================");
		System.out.println("SIGFarma ");
		System.out.println("API disponible en: http://localhost:8080/swagger-ui/index.html");
		System.out.println("Base de datos: PostgreSQL");
		System.out.println("===========================================\n");
	}

}
