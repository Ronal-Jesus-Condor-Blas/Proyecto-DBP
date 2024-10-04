package com.proyecto_dbp.proyecto_dbp;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(servers = {@Server(url = "/", description = "Default Server URL")})
@SpringBootApplication
public class ProyectoDbpApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoDbpApplication.class, args);
	}

}
