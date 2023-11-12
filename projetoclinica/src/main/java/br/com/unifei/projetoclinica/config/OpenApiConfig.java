package br.com.unifei.projetoclinica.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
  @Bean
  public OpenAPI usersMicroserviceOpenAPI() {
    return new OpenAPI()
        .info(
            new Info()
                .title("Sitema de gerenciamento para clínicas veterinárias")
                .description("Your API Description")
                .version("1.0"));
  }
}
