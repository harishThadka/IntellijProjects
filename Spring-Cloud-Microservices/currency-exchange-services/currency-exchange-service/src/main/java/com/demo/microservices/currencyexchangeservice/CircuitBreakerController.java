package com.demo.microservices.currencyexchangeservice;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



@RestController
public class CircuitBreakerController {

    private Logger loggger = LoggerFactory.getLogger(CircuitBreakerController.class);
    @GetMapping("/sample-api")
//    @Retry(name="sample-api",fallbackMethod = "hardCodedResponse")
    // CircuitBreaker breaks the connection after certain requests based on configuration
    @CircuitBreaker(name="sample-api",fallbackMethod = "hardCodedResponse")
    // RateLimiter allows some requests in certain time duration
    @RateLimiter(name="default")
    public String sampleApi(){
        loggger.info("Sample API received");
        ResponseEntity<String> responseEntity= new RestTemplate().getForEntity("http://localhost:8080/dummu-url", String.class);
        return responseEntity.getBody();
    }

    public String hardCodedResponse(Exception e){
        return "fallback-response";
    }
}
