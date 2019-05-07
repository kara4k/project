package com.demo.project.unit.factory;

import com.demo.project.dto.LessonDto;
import com.demo.project.dto.StudentDto;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.entity.StudentEntity;
import com.demo.project.entity.TeacherEntity;

import java.util.Set;

public interface TestObjectFactory {

    StudentDto createStudentDto();

    StudentEntity createStudentEntity();

    Set<StudentDto> createStudentDto(int size);

    Set<StudentEntity> createStudentEntity(int size);

    TeacherDto createTeacherDto();

    TeacherEntity createTeacherEntity();

    Set<TeacherDto> createTeacherDto(int size);

    Set<TeacherEntity> createTeacherEntity(int size);

    LessonDto createLessonDto();

    LessonEntity createLessonEntity();

    Set<LessonDto> createLessonDto(int size);

    Set<LessonEntity> createLessonEntity(int size);
}
