package com.microservices.userservice.controller;

import com.microservices.userservice.VO.ResponseTemplateVO;
import com.microservices.userservice.model.User;
import com.microservices.userservice.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("Inside save User of controller");
        return userService.saveUser(user);
    }

    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDept(@PathVariable("id") Long userId){
        return userService.getUserWithDept(userId);
    }

}
