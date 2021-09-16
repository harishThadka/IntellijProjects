package com.example.surveyservice;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@SequenceGenerator(name="question_id_seq", initialValue=1001, allocationSize=500)
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "question_id_seq")
    private long id;
    private String description;
    private String correctAnswer;
    @ElementCollection
    private List<String> options;

    public Question() {
    }

    public Question( String description, String correctAnswer, List<String> options) {
        this.description = description;
        this.correctAnswer = correctAnswer;
        this.options = options;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", correctAnswer='" + correctAnswer + '\'' +
                ", options=" + options +
                '}';
    }
}
