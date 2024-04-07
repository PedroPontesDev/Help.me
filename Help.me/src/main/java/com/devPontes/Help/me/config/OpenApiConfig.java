package com.devPontes.Help.me.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI swagger() {
		return new OpenAPI()
					.info(new Info()
							.title("Help.me Documentation Restfull Usage")
							.version("v1")
							.description("A Restaurant Helper Who Provides All Types Of Managment"));
	}
	

}
