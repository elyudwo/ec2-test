package com.example.mariaDB_practice.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Builder
public class Joke {
    @Id
    @GeneratedValue
    private Long id;

    private String ask;
    private String answer;
    private int year;

    public Joke() {

    }
}