package com.bloshound.webparserstatistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.MalformedURLException;
import java.net.URL;

@Configuration
public class Config {

    @Bean
    URL url() throws MalformedURLException {
        return new URL("https://");
    }


}
