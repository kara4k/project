package com.demo.project.converter;

import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("TeacherConverter")
public class TeacherConverter extends AbstractDtoDboConverter<TeacherDto, TeacherEntity> {

    public TeacherConverter() {
        super(TeacherDto.class, TeacherEntity.class);
    }
}
