package com.example.surveyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SurveyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SurveyServiceApplication.class, args);
    }

    @Profile("prod")
    @Bean
    public String dummy(){
        return "something";
    }

}
