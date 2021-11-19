package com.keyrus.r2dbcpoc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@EnableR2dbcRepositories
public class R2dbcpocApplication {

	public static void main(String[] args) {
		SpringApplication.run(R2dbcpocApplication.class, args);
	}

}
