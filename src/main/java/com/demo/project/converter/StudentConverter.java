package com.demo.project.converter;

import com.demo.project.dto.StudentDto;
import com.demo.project.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("StudentConverter")
public class StudentConverter extends AbstractDtoDboConverter<StudentDto, StudentEntity>{

    public StudentConverter() {
        super(StudentDto.class, StudentEntity.class);
    }

}
