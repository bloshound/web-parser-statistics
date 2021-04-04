package com.bloshound.webparserstatistics;

import com.bloshound.webparserstatistics.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class WebParserStatisticsApplication {

    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(WebParserStatisticsApplication.class, args);

        MainService mainService = (MainService) context.getBean(MainService.class);
        mainService.execute();

        context.close();
    }
}
