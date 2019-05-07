package com.demo.project.unit.factory;

import com.demo.project.consts.Status;
import com.demo.project.dto.LessonDto;
import com.demo.project.dto.StudentDto;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.entity.StudentEntity;
import com.demo.project.entity.TeacherEntity;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Supplier;

@Component
@Qualifier("RandomTestObjectFactory")
public class RandomTestObjectFactory implements TestObjectFactory {

    @Override
    public StudentDto createStudentDto() {
        final StudentDto studentDto = new StudentDto();
        studentDto.setId(RandomUtils.nextLong());
        studentDto.setFirstName(randomString());
        studentDto.setMiddleName(randomString());
        studentDto.setLastName(randomString());
        studentDto.setGrade(randomString());
        studentDto.setPhone(randomString());
        studentDto.setEmail(randomString());
        studentDto.setAbout(randomString());

        return studentDto;
    }

    @Override
    public StudentEntity createStudentEntity() {
        final StudentEntity studentEntity = new StudentEntity();
        studentEntity.setId(RandomUtils.nextLong());
        studentEntity.setFirstName(randomString());
        studentEntity.setMiddleName(randomString());
        studentEntity.setLastName(randomString());
        studentEntity.setLogin(randomString());
        studentEntity.setLogin(randomString());
        studentEntity.setGrade(randomString());
        studentEntity.setPhone(randomString());
        studentEntity.setEmail(randomString());
        studentEntity.setAbout(randomString());

        return studentEntity;
    }

    @Override
    public Set<StudentDto> createStudentDto(final int size) {
        return createSet(this::createStudentDto, size);
    }

    @Override
    public Set<StudentEntity> createStudentEntity(final int size) {
        return createSet(this::createStudentEntity, size);
    }

    @Override
    public TeacherDto createTeacherDto() {
        final TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(RandomUtils.nextLong());
        teacherDto.setFirstName(randomString());
        teacherDto.setMiddleName(randomString());
        teacherDto.setLastName(randomString());
        teacherDto.setExperience(randomString());
        teacherDto.setPhone(randomString());
        teacherDto.setEmail(randomString());
        teacherDto.setAbout(randomString());

        return teacherDto;
    }

    @Override
    public TeacherEntity createTeacherEntity() {
        final TeacherEntity teacherEntity = new TeacherEntity();
        teacherEntity.setId(RandomUtils.nextLong());
        teacherEntity.setFirstName(randomString());
        teacherEntity.setMiddleName(randomString());
        teacherEntity.setLastName(randomString());
        teacherEntity.setLogin(randomString());
        teacherEntity.setLogin(randomString());
        teacherEntity.setExperience(randomString());
        teacherEntity.setPhone(randomString());
        teacherEntity.setEmail(randomString());
        teacherEntity.setAbout(randomString());

        return teacherEntity;
    }

    @Override
    public Set<TeacherDto> createTeacherDto(final int size) {
        return createSet(this::createTeacherDto, size);
    }

    @Override
    public Set<TeacherEntity> createTeacherEntity(final int size) {
        return createSet(this::createTeacherEntity, size);
    }

    @Override
    public LessonDto createLessonDto() {
        final LessonDto lessonDto = new LessonDto();
        lessonDto.setId(RandomUtils.nextLong());
        lessonDto.setStartDate(new Date());
        lessonDto.setFinishDate(new Date());
        lessonDto.setPrice(new BigDecimal(RandomUtils.nextDouble(0d, 1000.99)));
        lessonDto.setTopic(randomString());
        lessonDto.setStatus(randomStatus());
        lessonDto.setDescription(randomString());
        lessonDto.setTeacher(createTeacherDto());
        lessonDto.setStudents(Collections.singleton(createStudentDto()));

        return lessonDto;
    }

    @Override
    public LessonEntity createLessonEntity() {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(RandomUtils.nextLong());
        lessonEntity.setStartDate(new Date());
        lessonEntity.setFinishDate(new Date());
        lessonEntity.setPrice(new BigDecimal(RandomUtils.nextDouble(0d, 1000.99)));
        lessonEntity.setTopic(randomString());
        lessonEntity.setStatus(randomStatus());
        lessonEntity.setDescription(randomString());
        lessonEntity.setTeacher(createTeacherEntity());
        lessonEntity.setStudents(Collections.singleton(createStudentEntity()));

        return lessonEntity;
    }

    @Override
    public Set<LessonDto> createLessonDto(final int size) {
        return createSet(this::createLessonDto, size);
    }

    @Override
    public Set<LessonEntity> createLessonEntity(final int size) {
        return createSet(this::createLessonEntity, size);
    }

    private <T> Set<T> createSet(final Supplier<T> supplier, final int size) {
        final Set<T> set = new HashSet<>(size);

        for (int i = 0; i < size; i++) {
            set.add(supplier.get());
        }

        return set;
    }

    private Status randomStatus() {
        final Status[] values = Status.values();
        return values[RandomUtils.nextInt(0, values.length)];
    }

    private String randomString() {
        return RandomStringUtils.randomAlphanumeric(5, 11);
    }
}
