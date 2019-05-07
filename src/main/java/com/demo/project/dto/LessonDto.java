package com.demo.project.dto;

import com.demo.project.consts.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Data
@EqualsAndHashCode(callSuper = true)
public class LessonDto extends AbstractDto{

    private Date startDate;

    private Date finishDate;

    private BigDecimal price;

    private Status status;

    private String topic;

    private String description;

    private TeacherDto teacher;

    private Set<StudentDto> students;

}
