package com.demo.project.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "STUDENTS")
@EqualsAndHashCode(callSuper = true)
public class StudentEntity extends PersonEntity {

    @Column(name = "GRADE")
    private String grade;

}
