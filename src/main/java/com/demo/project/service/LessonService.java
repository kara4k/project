package com.demo.project.service;

import com.demo.project.converter.DtoDboConverter;
import com.demo.project.dto.LessonDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.repository.IBaseRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class LessonService extends AbstractService<LessonDto, LessonEntity> {


    public LessonService(@Qualifier("LessonRepository")
                         final IBaseRepository<LessonEntity> repository,
                         final DtoDboConverter<LessonDto, LessonEntity> converter) {

        super(repository, converter);
    }

    @Override
    protected String getNotFoundMessage(final Long id) {
        return String.format("Lesson with id %d not found.", id);
    }
}
