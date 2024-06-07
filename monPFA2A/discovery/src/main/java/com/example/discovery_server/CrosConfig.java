package com.example.discovery_server;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrosConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Autoriser toutes les origines
        config.addAllowedOrigin("*");

        // Autoriser toutes les en-têtes
        config.addAllowedHeader("*");

        // Autoriser toutes les méthodes HTTP
        config.addAllowedMethod("*");

        // Permettre l'envoi des credentials (cookies, autorisation HTTP)
        config.setAllowCredentials(true);

        // Enregistrer la configuration CORS pour toutes les routes
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}

