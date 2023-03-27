package com.example.mariaDB_practice.controller;

import com.example.mariaDB_practice.dto.DayInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ReservationController {

    @PostMapping("/reserve")
    public ResponseEntity<String> jsonTest(@RequestBody DayInfo dayInfo) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dayInfo);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(json, headers, HttpStatus.OK);
    }

}
