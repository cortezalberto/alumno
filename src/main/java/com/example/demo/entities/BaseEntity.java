package com.example.demo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@MappedSuperclass

@Getter
@Setter

public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected int id;
}
