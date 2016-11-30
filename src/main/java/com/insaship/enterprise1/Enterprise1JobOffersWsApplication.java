package com.insaship.enterprise1;

import com.insaship.enterprise1.conf.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)

public class Enterprise1JobOffersWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Enterprise1JobOffersWsApplication.class, args);
	}
}
