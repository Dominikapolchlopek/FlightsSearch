package com.piotr.flightsearchapi;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Configure {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Zezwól na wszystkie ścieżki w API
                        .allowedOrigins("http://localhost:5173") // Twój frontend w React
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Dozwolone metody HTTP
                        .allowedHeaders("*") // Dozwolone wszystkie nagłówki (Content-Type, Authorization itp.)
                        .allowCredentials(true);
            }
        };
    }
}