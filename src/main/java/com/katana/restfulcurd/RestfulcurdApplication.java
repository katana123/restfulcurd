package com.katana.restfulcurd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RestfulcurdApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestfulcurdApplication.class, args);
    }
}
