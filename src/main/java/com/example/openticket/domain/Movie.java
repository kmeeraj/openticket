package com.example.openticket.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Data
@Entity
public class Movie {
    private @Id
    @GeneratedValue
    Long id;
    private String movieName;
    private String Language;
    private String genre;
    private String actors;
    private String directors;
    private String producers;
    @Override
    public String toString() {
        return "Movie{" +
                "movieName='" + movieName + '\'' +
                ", Language='" + Language + '\'' +
                '}';
    }
}
