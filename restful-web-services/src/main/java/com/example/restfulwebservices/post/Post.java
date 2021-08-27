package com.example.restfulwebservices.post;

import com.example.restfulwebservices.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jdk.nashorn.internal.ir.annotations.Ignore;

import javax.persistence.*;

@Entity
@SequenceGenerator(name="post_id_seq", initialValue=1002, allocationSize=100)
public class Post {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="post_id_seq")
    private Long id;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;

    public Post() {
    }


    public Post(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Long getId() {
        return id;
        
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
