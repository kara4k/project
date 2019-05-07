package com.demo.project.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private Long id;
}
