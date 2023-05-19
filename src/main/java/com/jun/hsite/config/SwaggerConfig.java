package com.jun.hsite.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "Web API",
                description = "Community Web API"
        ))
@RequiredArgsConstructor
@Configuration
public class SwaggerConfig {

}