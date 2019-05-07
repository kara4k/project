package com.demo.project.service;

import com.demo.project.converter.DtoDboConverter;
import com.demo.project.dto.StudentDto;
import com.demo.project.entity.StudentEntity;
import com.demo.project.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class StudentService extends AbstractService<StudentDto, StudentEntity> {

    public StudentService(@Qualifier("StudentRepository")
                          final IBaseRepository<StudentEntity> repository,
                          final DtoDboConverter<StudentDto, StudentEntity> converter) {
        super(repository, converter);
    }

    @Override
    protected String getNotFoundMessage(final Long id) {
        return String.format("Student with id %d not found.", id);
    }
}
