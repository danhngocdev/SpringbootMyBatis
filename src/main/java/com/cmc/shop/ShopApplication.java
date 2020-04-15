package com.cmc.shop;

import java.util.Arrays;
import java.util.Collections;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@SpringBootApplication
@MapperScan("com.cmc.shop.dao")
@ComponentScan("com.cmc.shop")

public class ShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);	
}
	  
}
