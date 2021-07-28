package com.example.springDemo.Student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

import static java.time.Month.*;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository){
        return args -> {
            Student harish = new Student(1L, "harish", "harish@gmail.com",
                    LocalDate.of(1995, NOVEMBER, 4));
            Student sushma = new Student(2L, "sushma", "sushma@gmail.com",
                    LocalDate.of(1997, JANUARY, 12));
            repository.saveAll(List.of(harish,sushma));
        };
    }


}
