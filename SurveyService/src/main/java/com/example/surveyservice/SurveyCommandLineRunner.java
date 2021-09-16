package com.example.surveyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SurveyCommandLineRunner implements CommandLineRunner {

    @Autowired
    private SurveyRepo surveyRepo;

    @Autowired
    private  QuestionRepo questionRepo;



    @Override
    public void run(String... args) throws Exception {

        Question question1 = new Question(
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question2 = new Question(
                "Most Populous Country in the World", "China", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question3 = new Question(
                "Highest GDP in the World", "United States", Arrays.asList(
                "India", "Russia", "United States", "China"));
        Question question4 = new Question(
                "Second largest english speaking country", "India", Arrays
                .asList("India", "Russia", "United States", "China"));

        List<Question> questions = new ArrayList<>(Arrays.asList(question1,
                question2, question3, question4));

        Survey survey = new Survey(1, "My Favorite Survey",
                "Description of the Survey", questions);

       surveyRepo.save(survey);
    }
}
