package com.example.surveyservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "/",produces = MediaType.APPLICATION_JSON_VALUE)
public class SurveyController {

    @Autowired
    private SurveyService surveyService;

    private Logger logger = LoggerFactory.getLogger(SurveyController.class);

    @GetMapping(path = "surveys", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Survey> retrieveAllSurveys() {
        logger.info("Get Survey");
        return surveyService.retrieveAllSurveys();
    }

    @PostMapping("surveys")
    public Survey postSurvey(@RequestBody Survey survey) {
        logger.info("POST Survey");
        return surveyService.addSurvey(survey);
    }

    @GetMapping("surveys/{surveyId}/questions")
    public ResponseEntity<List<Question>> retrieveAllQuestionsForSurvey(@PathVariable long surveyId) {
        logger.info("retrieveAllQuestionsForSurvey");
        List<Question> questions = surveyService.retrieveQuestions(surveyId);

        if (questions == null) {
            ResponseEntity.notFound().build();
        }

        return new ResponseEntity<>(questions, HttpStatus.OK);
    }


    @PostMapping("surveys/{surveyId}/questions")
    public ResponseEntity<Void> postQuestionsForSurvey(@PathVariable long surveyId, @RequestBody Question question) {
        logger.info("postQuestionsForSurvey");

        Question out = surveyService.addQuestionToSurvey(surveyId, question);

        if (out == null) {
            return ResponseEntity.noContent().build();
        }

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(question.getId()).toUri();


        return ResponseEntity.created(location).build();
    }


    @GetMapping("surveys/{surveyId}/questions/{questionId}")
    public ResponseEntity<Question> getQuestionFromSurvey(@PathVariable long surveyId, @PathVariable long questionId) {

        logger.info("getQuestionFromSurvey");

        Question out = surveyService.getQuestionFromSurvey(surveyId, questionId);

        if (out == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(out);
    }

}
