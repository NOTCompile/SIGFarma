package com.sigfarma.sigfarma_api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        Server localServer = new Server();
        localServer.setUrl("http://localhost:8080");
        localServer.setDescription("Servidor Local de Desarrollo");

        return new OpenAPI()
                .servers(List.of(localServer))
                .info(new Info()
                        .title("SigFarma - Sistema de Gestión de Boticas FarmaAngel")
                        .version("1.0")
                        .description("API REST para la automatización y trazabilidad de SIGFarma (Ventas, Inventario/Lotes y Reportes).")
                        .contact(new Contact()
                                .name("NOTCompile")
                                .email("notcompile@gmail.com")
                ));
    }
}
