package com.CarList;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.extern.slf4j.Slf4j;

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
@Slf4j
public class CarListApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarListApplication.class, args);
		//System.out.println("YOURS PROJECTS IS RUNNING.........");
		
		
		/* logging*/
//		log.trace("its trace message");
//		log.debug("its debug message");
		log.info("YOURS PROJECTS IS RUNNING.........");
//		log.warn("its warn message");
//		log.error("its error message");

		/* Some Important Points*/
		/*
		* When u use log annotation -> @Slf4j than don't create logger instance.
		* When u use logger instance -> @Slf4j annotation don't use.
		* Both together don't use.
		* */
	}

}
