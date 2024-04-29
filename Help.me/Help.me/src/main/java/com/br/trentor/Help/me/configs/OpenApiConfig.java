package com.br.trentor.Help.me.configs;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
			.info(new Info()
				.title("Restaurant Helper WebService")
				.version("v1")
				.description("WebService Created With Objective To Help Reastaurants To Manage All Type Off Problems")
				);
	}

}
