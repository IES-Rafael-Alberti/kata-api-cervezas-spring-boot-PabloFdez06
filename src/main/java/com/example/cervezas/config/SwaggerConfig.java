package com.example.cervezas.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Kata API Cervezas")
                        .version("1.0.0")
                        .description("API REST CRUD para gestionar cervezas, cervecerías, categorías y estilos de cerveza")
                        .contact(new Contact()
                                .name("Pablo Fernández")
                                .url("https://github.com/PabloFdez06"))
                        .license(new License()
                                .name("MIT")
                                .url("https://opensource.org/licenses/MIT")));
    }

}

