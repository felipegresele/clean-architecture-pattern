package com.example.clean_arquitecture.Clean.Arquitecture.entrypoint.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI getOpenAPI() {

        Info info = new Info();

        info.title("Clean Arquitecture Project");
        info.description("Clean Arquitecture Project API");

        return new OpenAPI().info(info);

    }

}
