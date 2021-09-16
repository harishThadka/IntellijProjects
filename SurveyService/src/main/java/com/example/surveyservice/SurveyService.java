package com.example.surveyservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class SurveyService {


    @Autowired
    private SurveyRepo surveyRepo;

    @Autowired
    private QuestionRepo questionRepo;

    public  Survey addSurvey(Survey survey){

        return surveyRepo.save(survey);
    }

    public List<Survey> retrieveAllSurveys() {
        return surveyRepo.findAll();
    }

    public Survey retrieveSurvey(long surveyId) {

        return surveyRepo.findById(surveyId).get();
    }

    public List<Question> retrieveQuestions(long surveyId) {

        Optional<Survey> optionalSurvey = surveyRepo.findById(surveyId);

        if(optionalSurvey.isEmpty()){
            return null;
        }

        return optionalSurvey.get().getQuestions();
    }



    public Question retrieveQuestion(String surveyId, String questionId) {

        return new Question();

    }


    public Question addQuestionToSurvey(long surveyId, Question question) {

        Optional<Survey> optionalSurvey = surveyRepo.findById(surveyId);

        if (optionalSurvey.isEmpty()) {
            return null;
        }

        Survey survey = optionalSurvey.get();

        questionRepo.save(question);

        survey.getQuestions().add(question);

        surveyRepo.save(survey);

        return question;
    }

    public Question getQuestionFromSurvey(long surveyId, long questionId) {

        Optional<Survey> optionalSurvey = surveyRepo.findById(surveyId);

        if (optionalSurvey.isEmpty()) {
            return null;
        }
        for(Question q: optionalSurvey.get().getQuestions()){

            if(q.getId()==questionId){
                return q;
            }
        }

        return null;
    }
}
