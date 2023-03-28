package com.example.mariaDB_practice.service;

import com.example.mariaDB_practice.domain.Joke;
import com.example.mariaDB_practice.dto.JokeDto;
import com.example.mariaDB_practice.repository.JokeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class JokeService {

    private final JokeRepository jokeRepository;
    ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 예약처리
     * Json 형태로 들어온 데이터 파싱해서 reservationRepository save 메소드 사용
     */

    @Transactional
    public Long save(Joke joke) {
        jokeRepository.save(joke);
        return joke.getId();
    }


    public List<String> jsonList(List<Joke> joke) throws JsonProcessingException {
        List<String> jsonList = new ArrayList<>();
        for(Joke jokeToDto : joke) {
            JokeDto jokeDto = JokeDto.builder()
                    .ask(jokeToDto.getAsk())
                    .answer(jokeToDto.getAnswer())
                    .build();
            String json = objectMapper.writeValueAsString(jokeDto);
            jsonList.add(json);
        }
        return jsonList;
    }
}