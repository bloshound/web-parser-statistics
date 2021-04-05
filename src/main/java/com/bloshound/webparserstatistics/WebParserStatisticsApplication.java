package com.bloshound.webparserstatistics;

import com.bloshound.webparserstatistics.service.MainService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

@SpringBootApplication
public class WebParserStatisticsApplication {
    private static final Logger logger = Logger.getLogger(WebParserStatisticsApplication.class.getName());


    public static void main(String[] args) throws IOException {
        ConfigurableApplicationContext context = SpringApplication.run(WebParserStatisticsApplication.class, args);
        MainService mainService = (MainService) context.getBean(MainService.class);

        input(mainService);
        context.close();
    }

    public static void input(MainService mainService) {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String input;

        while (true) {
            System.out.println("for exit type <exit>. for lunch application - input url of the existing site:");
            try {
                input = consoleReader.readLine();
                if (input.equalsIgnoreCase("exit")) {
                    System.out.println("exit from application");
                    break;
                }

                mainService.execute(input);

            } catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }
    }
}

