package com.example.mariaDB_practice.repository;

import com.example.mariaDB_practice.domain.Joke;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class JokeRepository {

    private final EntityManager em;

    public void save(Joke joke) {
        em.persist(joke);
    }

    public List<Joke> findAll() {
        return em.createQuery("select p from Joke as p order by id", Joke.class)
                .getResultList();
    }

    public List<Joke> findByYear(int year) {
        return em.createQuery("select p from Joke as p where p.year = :num", Joke.class)
                .setParameter("num",year)
                .getResultList();
    }
}