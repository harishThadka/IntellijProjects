package com.example.surveyservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepo extends JpaRepository<Survey,Long> {

    List<Survey> findByDescription(@Param("desc") String description);
}
