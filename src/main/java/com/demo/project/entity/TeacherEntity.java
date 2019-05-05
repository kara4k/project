package com.demo.project.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TEACHERS")
@EqualsAndHashCode(callSuper = true)
public class TeacherEntity extends PersonEntity{

    @Column(name = "experience")
    private String experience;

}


