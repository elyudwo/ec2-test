package com.example.mariaDB_practice.repository;

import com.example.mariaDB_practice.domain.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReservationRepository {

    private final EntityManager em;

    public void save(Reservation reservation) {
        em.persist(reservation);
    }

    public List<Reservation> findAll() {
        return em.createQuery("select p from Reservation as p order by id",Reservation.class)
                .getResultList();
    }

    public List<Reservation> findByNumber(String num) {
        return em.createQuery("select p from Reservation as p where p.number = :num",Reservation.class)
                .setParameter("num",num)
                .getResultList();
    }
}