package com.api.carlosautopecas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class CarlosautopecasApplication {

	public static void main(String[] args) {
		TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));

		SpringApplication.run(CarlosautopecasApplication.class, args);
	}

}
