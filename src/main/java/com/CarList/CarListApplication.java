package com.CarList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
		info = @Info(
				title = "Brand-Model REST API Documentation",
				description = "Brand-Model Service REST API",
				version = "v1",
				contact = @Contact(
						name = "Ganesh Kumar",
						email = "Ganeshkumar@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Share Point URL Brand-Model Service REST API",
				url = "example.com"
		)
		)
@SpringBootApplication
public class CarListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarListApplication.class, args);
		System.out.println("YOURS PROJECTS IS RUNNING.........");
	}

}
