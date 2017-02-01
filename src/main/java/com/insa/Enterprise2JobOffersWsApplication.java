package com.insa;

import com.insa.conf.SwaggerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@Import(SwaggerConfig.class)
@SpringBootApplication
public class Enterprise2JobOffersWsApplication {

	public static void main(String[] args) {
		SpringApplication.run(Enterprise2JobOffersWsApplication.class, args);
	}
}
