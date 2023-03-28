package com.example.mariaDB_practice.controller;

import com.example.mariaDB_practice.domain.Joke;
import com.example.mariaDB_practice.repository.JokeRepository;
import com.example.mariaDB_practice.service.JokeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class HomeController {

    private final JokeRepository jokeRepository;
    private final JokeService jokeService;

    @ResponseBody
    @GetMapping("/hello")
    public String responseBodyString() {
        return "hello!";
    }

    @GetMapping("/search/{year}")
    public ResponseEntity<List<String>> jokeList(@PathVariable int year) throws JsonProcessingException {
        List<Joke> joke = jokeRepository.findByYear(year);
        List<String> jsonList = jokeService.jsonList(joke);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(jsonList, headers, HttpStatus.OK);
    }

}