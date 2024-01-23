package com.RestApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class RestApiApplication extends SpringServletContainerInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RestApiApplication.class, args);
        System.out.println("++++++++++++++++++++++++++++Application has been started successfully++++++++++++++++++++++++++++++++ ");
    }

}
