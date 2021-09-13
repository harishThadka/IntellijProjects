package com.example.springconcepts;

import com.example.componentScan.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.example.componentScan")
@ComponentScan("com.example.springconcepts")
@PropertySource("app.properties")
public class SpringConceptsApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringConceptsApplication.class);
    public static void main(String[] args) {


        ApplicationContext applicationContext = SpringApplication.run(SpringConceptsApplication.class, args);

        Employee employee = applicationContext.getBean(Employee.class);
        logger.info("Employee Bean: {}",employee);

        Person person = applicationContext.getBean(Person.class);
        logger.info("Person: {}",person);

        logger.info("Application context environment: {}",applicationContext.getEnvironment());

        Properties properties = applicationContext.getBean(Properties.class);

        logger.info("Properties Configuration: {}",properties.getUrl());




    }

}
