package com.vismotechnologies.blogsservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(
        title=" Blogger of Vismo technologies",
        description="Blogger Service web site for Vismo Technologies",
        version = "1.0",
        contact = @Contact(
                name = "Mallikarjun Ramdurg",
                email = "info@vismotechnologies.com",
                url = "www.vismotechnologies.com"
        ),
        license = @License(
                name = "Vismo Technologies",
                url = "www.vismotechnologies.com"
        ))
)
public class BlogsServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogsServiceApplication.class, args);
    }


    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI().addSecurityItem(new SecurityRequirement().
                        addList("Bearer Authentication"))
                .components(new Components().addSecuritySchemes
                        ("Bearer Authentication", createAPIKeyScheme()));
    }
    private SecurityScheme createAPIKeyScheme() {
        return new SecurityScheme().type(SecurityScheme.Type.HTTP)
                .bearerFormat("JWT")
                .scheme("bearer");
    }
}
