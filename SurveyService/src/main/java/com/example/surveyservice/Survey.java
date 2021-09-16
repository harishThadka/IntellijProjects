package com.example.surveyservice;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Survey {

    @Id
    @GeneratedValue
    private long id;
    private String title;
    private String description;
    @OneToMany(cascade = {CascadeType.ALL})
    private List<Question> questions;

    public Survey() {
    }

    public Survey(long id, String title, String description, List<Question> questions) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.questions = questions;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Survey survey = (Survey) o;
        return id == survey.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", questions=" + questions +
                '}';
    }
}
