package com.example.surveyservice;

import org.json.JSONException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.MultiValueMap;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Base64;

import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
@SpringBootTest(classes = SurveyServiceApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;

    @Autowired
    TestRestTemplate restTemplate;

    HttpHeaders headers = new HttpHeaders();


   @BeforeEach
   public void before(){
       System.out.println("Before Each Method");
       headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
       String userId = "user1";
       String password = "secret";
       String auth = userId + ":"+password;
//       byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes(Charset.forName("US-ASCII")));
       byte[] encodedAuth = Base64.getEncoder().encode(auth.getBytes());
       String headerValue = "Basic "+ new String(encodedAuth);

       headers.add("Authorization",headerValue);

   }


    @Test
    public void TestGetQuestionFromSurvey() throws JSONException {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        System.out.println(headers);
        System.out.println("PORT: "+port);
        String url = "http://localhost:"+port+"/surveys/1/questions/1002";

//        String response = restTemplate.getForObject(url,String.class);

        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET,entity,String.class);


        String expected = "{description:\"Most Populous Country in the World\"}";
         JSONAssert.assertEquals(expected,response.getBody(),false);

//        System.out.println("Response: "+response);

    }

    @Test
    public void TestAddQuestionToSurvey() throws JSONException {
        System.out.println("PORT: "+port);
        String url = "http://localhost:"+port+"/surveys/1/questions";

        Question question1 = new Question(
                "Integration test", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        HttpEntity<Question> entity = new HttpEntity<Question>(question1,headers);
         ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST,entity,String.class);

        String actual = response.getHeaders().get(HttpHeaders.LOCATION).get(0);
        System.out.println("Response: "+response);


        assertTrue(actual.contains("/surveys/1/questions"));

    }
}
