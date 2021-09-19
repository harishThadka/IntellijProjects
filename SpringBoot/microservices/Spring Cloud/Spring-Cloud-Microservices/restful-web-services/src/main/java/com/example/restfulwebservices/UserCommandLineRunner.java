package com.example.restfulwebservices;

import com.example.restfulwebservices.user.User;
import com.example.restfulwebservices.user.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(UserCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        // https://www.baeldung.com/java-init-list-one-line
        // Jdk 9 - List.of
        List<User> users = Arrays.asList(new User("Harish",new Date()),new User("Raki", new Date()));
        logger.info("Users created" + users);
        userRepository.saveAll(users);
    }
}
