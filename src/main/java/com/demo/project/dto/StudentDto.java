package com.demo.project.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class StudentDto extends AbstractDto {

    private String firstName;

    private String middleName;

    private String lastName;

    private String grade;

    private String phone;

    private String email;

    private String about;

}
