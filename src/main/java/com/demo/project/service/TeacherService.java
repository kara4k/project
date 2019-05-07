package com.demo.project.service;

import com.demo.project.converter.DtoDboConverter;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.TeacherEntity;
import com.demo.project.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TeacherService extends AbstractService<TeacherDto, TeacherEntity> {


    public TeacherService(@Qualifier("TeacherRepository")
                          final IBaseRepository<TeacherEntity> repository,
                          final DtoDboConverter<TeacherDto, TeacherEntity> converter) {

        super(repository, converter);
    }

    @Override
    protected String getNotFoundMessage(final Long id) {
        return String.format("Teacher with id %d not found.", id);
    }
}
