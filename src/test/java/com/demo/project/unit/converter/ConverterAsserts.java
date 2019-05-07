package com.demo.project.unit.converter;

import com.demo.project.dto.LessonDto;
import com.demo.project.dto.PersonDto;
import com.demo.project.dto.StudentDto;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.entity.PersonEntity;
import com.demo.project.entity.StudentEntity;
import com.demo.project.entity.TeacherEntity;
import org.junit.Assert;
import org.springframework.util.CollectionUtils;

final class ConverterAsserts {

    private ConverterAsserts() {}

    static void assertConverted(final StudentDto dto, final StudentEntity entity){
        assertPersonConverted(dto,entity);
        Assert.assertEquals(dto.getGrade(), entity.getGrade());
    }

    static void assertConverted(final TeacherDto dto, final TeacherEntity entity){
        assertPersonConverted(dto, entity);
        Assert.assertEquals(dto.getExperience(), entity.getExperience());
    }

    static void assertConverted(final LessonDto dto, final LessonEntity entity){
        Assert.assertNotNull(dto);
        Assert.assertNotNull(entity);

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getStartDate(), entity.getStartDate());
        Assert.assertEquals(dto.getFinishDate(), entity.getFinishDate());
        Assert.assertEquals(dto.getPrice(), entity.getPrice());
        Assert.assertEquals(dto.getStatus(), entity.getStatus());
        Assert.assertEquals(dto.getTopic(), entity.getTopic());
        Assert.assertEquals(dto.getDescription(), entity.getDescription());

        Assert.assertNotNull(dto.getTeacher());
        Assert.assertNotNull(entity.getTeacher());

        Assert.assertFalse(CollectionUtils.isEmpty(dto.getStudents()));
        Assert.assertFalse(CollectionUtils.isEmpty(entity.getStudents()));
        Assert.assertEquals(dto.getStudents().size(), entity.getStudents().size());
    }

    private static void assertPersonConverted(final PersonDto dto, final PersonEntity entity) {
        Assert.assertNotNull(dto);
        Assert.assertNotNull(entity);

        Assert.assertEquals(dto.getId(), entity.getId());
        Assert.assertEquals(dto.getFirstName(), entity.getFirstName());
        Assert.assertEquals(dto.getMiddleName(), entity.getMiddleName());
        Assert.assertEquals(dto.getLastName(), entity.getLastName());
        Assert.assertEquals(dto.getPhone(), entity.getPhone());
        Assert.assertEquals(dto.getEmail(), entity.getEmail());
        Assert.assertEquals(dto.getAbout(), entity.getAbout());
    }

}
