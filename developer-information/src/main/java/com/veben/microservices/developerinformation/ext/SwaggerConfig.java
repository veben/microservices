package com.veben.microservices.developerinformation.ext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .host("localhost:8092")
                .select()
                .apis(basePackage("com.veben.microservices.developerinformation.ext.rest"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Developer information's",
                "Developer information's management",
                "0.0.1",
                "Terms of service",
                new Contact("Benoit Veyrière", "https://stackoverflow.com/users/8718377/veben", "benoit.veyriere@gmail.com"),
                "MIT License", "https://github.com/veben/microservices/blob/master/LICENSE.md", Collections.emptyList());
    }
}
