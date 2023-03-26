package com.example.mariaDB_practice.domain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Reservation {
    @Id
    @GeneratedValue
    private String id;

    private String name;
    private String number;
    private String phoneNumber;

}