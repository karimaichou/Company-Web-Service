package com.insaship.enterprise1.conf;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Swagger configuration.
 *
 * Created by Franck-Gravouil on 17/11/2016.
 */
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket documentation() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(regex("/api/.*"))
                .build()
                .pathMapping("/")
                .apiInfo(metadata())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Company Demo API")
                .description("Company Demo API allows to get company offers")
                .version("1.0")
                .build();
    }
}
