package com.example.springconcepts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Comparator;
import java.util.HashMap;

@Component
//@Scope("prototype")
public class Employee {

    private long id;
    private String name;

    private static Logger logger = LoggerFactory.getLogger(Employee.class);

    public Employee(){
        logger.info("Bean getting Initialised");
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PostConstruct
    public void postConstruct(){
        logger.info("********Post Construct**********");
    }

    @PreDestroy
    public void preDestroy(){
        logger.info("********Pre Destroy Method**********");
    }



}
