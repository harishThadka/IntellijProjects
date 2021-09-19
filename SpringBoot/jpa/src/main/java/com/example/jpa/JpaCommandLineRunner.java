package com.example.jpa;

import com.example.jpa.entity.User;
import com.example.jpa.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class JpaCommandLineRunner implements CommandLineRunner {


    private final Logger logger =  LoggerFactory.getLogger(JpaCommandLineRunner.class);
    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Harish","admin");
        long id = userDAOService.insert(user);
        logger.info("User is created: "+user);

    }
}
