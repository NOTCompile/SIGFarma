package com.sigfarma.sigfarma_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;

public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("SigFarma - Sistema de Gestión de Boticas FarmaAngel")
                        .version("1.0")
                        .description("API de SIGFarma")
                        .contact(new Contact()
                                .name("NOTCompile")
                                .email("notcompile@gmail.com")
                ));
    }
}
