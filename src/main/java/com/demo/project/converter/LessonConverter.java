package com.demo.project.converter;

import com.demo.project.dto.LessonDto;
import com.demo.project.dto.StudentDto;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.entity.StudentEntity;
import com.demo.project.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Qualifier("LessonConverter")
public class LessonConverter extends AbstractDtoDboConverter<LessonDto, LessonEntity> {

    private final TeacherConverter teacherConverter;
    private final StudentConverter studentConverter;

    public LessonConverter(final TeacherConverter teacherConverter, final StudentConverter studentConverter) {
        super(LessonDto.class, LessonEntity.class);
        this.teacherConverter = teacherConverter;
        this.studentConverter = studentConverter;
    }

    @Override
    protected void convertToDtoExtras(final LessonEntity entity, final LessonDto dto) {
        if (entity.getTeacher() != null) {
            final TeacherDto teacherDto = teacherConverter.convertToDto(entity.getTeacher());
            dto.setTeacher(teacherDto);
        }

        if (!CollectionUtils.isEmpty(entity.getStudents())) {
            final Set<StudentDto> studentDtos = entity.getStudents().stream()
                .map(studentConverter::convertToDto)
                .collect(Collectors.toSet());

            dto.setStudents(studentDtos);
        }
    }

    @Override
    protected void convertToEntityExtras(final LessonDto dto, final LessonEntity entity) {
        if (dto.getTeacher() != null) {
            final TeacherEntity teacherEntity = teacherConverter.convertToEntity(dto.getTeacher());
            entity.setTeacher(teacherEntity);
        }

        if (!CollectionUtils.isEmpty(dto.getStudents())) {
            final Set<StudentEntity> studentEntities = dto.getStudents().stream()
                .map(studentConverter::convertToEntity)
                .collect(Collectors.toSet());

            entity.setStudents(studentEntities);
        }
    }
}
