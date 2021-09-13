package com.example.springconcepts;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

    @Value("${yahoo.url}")
    private String url;

    public String getUrl() {
        return url;
    }
}
