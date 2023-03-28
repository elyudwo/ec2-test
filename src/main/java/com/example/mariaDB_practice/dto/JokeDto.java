package com.example.mariaDB_practice.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class JokeDto {

    private String ask;

    private String answer;

    public JokeDto(String ask, String answer) {
        this.ask = ask;
        this.answer = answer;
    }
}