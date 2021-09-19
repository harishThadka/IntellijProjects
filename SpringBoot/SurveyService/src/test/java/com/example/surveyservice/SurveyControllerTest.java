package com.example.surveyservice;


import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Arrays;

@WebMvcTest(SurveyController.class)
@WithMockUser(username = "user1", password = "secret")
public class SurveyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SurveyService surveyService;

    @Test
//    @WithMockUser(username = "user1", password = "secret")
    public void TestGetQuestionFromSurvey() throws Exception {

        Question question1 = new Question(
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        Mockito.when(surveyService.getQuestionFromSurvey(Mockito.anyLong(),Mockito.anyLong()))
                .thenReturn(question1);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/surveys/1/questions/1002")
                        .accept(MediaType.APPLICATION_JSON);
        MvcResult response= mockMvc.perform(requestBuilder).andReturn();


//        System.out.println("Response: "+response);
        String expected = "{description:\"Largest Country in the World\"}";
        JSONAssert.assertEquals(expected,response.getResponse().getContentAsString(),false);



    }

}
