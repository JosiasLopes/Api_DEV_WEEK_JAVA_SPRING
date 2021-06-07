package com.projeto.bootcamp;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;


//a anotation abaixo diz que essa é uma application Spring
//o metodo run da classe SprongApplication é onde inicia a aplicação
@SpringBootApplication
public class BootcampApplication {

	public static void main(String[] args) {


		SpringApplication.run(BootcampApplication.class, args);

	}

	//configura openapi
	@Bean
	public OpenAPI customOpenApi(){
		OpenAPI info = new OpenAPI().info(new Info().title("sasas").version("1.0").termsOfService("http://swagger.io/terms").license(
				new License().name("apache 2.0").url("http://springdoc.org")
		));
		return info;
    }

}
