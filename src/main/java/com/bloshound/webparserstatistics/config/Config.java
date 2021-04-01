package com.bloshound.webparserstatistics.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public String inputUrl() {
        return "https://a.a";
    }
}
