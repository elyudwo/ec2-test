package com.example.mariaDB_practice.service;

import com.example.mariaDB_practice.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    /**
     * 예약처리
     * Json 형태로 들어온 데이터 파싱해서 reservationRepository save 메소드 사용
     */
    @Transactional
    public void reserve() {

    }

}