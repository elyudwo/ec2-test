package com.example.mariaDB_practice.controller;

import com.example.mariaDB_practice.domain.Joke;
import com.example.mariaDB_practice.dto.JokeDto;
import com.example.mariaDB_practice.service.JokeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.time.LocalDate;

@Controller
@Slf4j
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @PostMapping("/postJoke")
    public void postJoke(@RequestBody JokeDto jokeDto) {
        LocalDate now = LocalDate.now();
        int year = now.getYear();

        Joke joke = Joke.builder()
                .ask(jokeDto.getAsk())
                .answer(jokeDto.getAnswer())
                .year(year)
                .build();
        jokeService.save(joke);
    }
}