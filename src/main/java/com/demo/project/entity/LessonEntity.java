package com.demo.project.entity;

import com.demo.project.consts.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@Entity
@Table(name = "LESSONS")
@EqualsAndHashCode(callSuper = true)
public class LessonEntity extends AbstractEntity {

    @Column(name = "START_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;

    @Column(name = "FINISH_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finishDate;

    @Column(name = "PRICE")
    private BigDecimal price;

    @Enumerated
    @Column(name = "STATUS")
    private Status status;

    @Column(name = "TOPIC")
    private String topic;

    @Column(name = "DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "TEACHER_ID", nullable = false)
    private TeacherEntity teacher;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENTS_LESSONS", joinColumns = {@JoinColumn(name = "LESSON_ID")},
            inverseJoinColumns = {@JoinColumn(name = "STUDENT_ID")})
    @Fetch(value = FetchMode.SUBSELECT)
    private Set<StudentEntity> students;

}
