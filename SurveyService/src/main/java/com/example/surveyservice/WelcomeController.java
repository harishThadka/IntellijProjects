package com.example.surveyservice;

import com.example.surveyservice.configuration.BasicConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class WelcomeController {

    @Value("${welcome.message}")
    private String message;

    @Autowired
    private Environment env;

    @Autowired
    private BasicConfiguration basicConfiguration;

    @GetMapping(path = "welcome")
    public String test(){
        return message +  "running on port "+env.getProperty("server.port");
    }

    @GetMapping("/configuration")
    public Map getBasicConfig(){
//        return basicConfiguration;

        Map map = new HashMap();

        map.put("number",basicConfiguration.getNumber());
        map.put("message",basicConfiguration.getMessage());
        map.put("value",basicConfiguration.isValue());

        return  map;
    }
}
