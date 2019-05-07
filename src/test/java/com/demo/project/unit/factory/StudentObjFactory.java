package com.demo.project.unit.factory;

import com.demo.project.dto.StudentDto;
import com.demo.project.entity.StudentEntity;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("StudentObjFactory")
public class StudentObjFactory extends AbstractDboDtoFactory<StudentDto, StudentEntity> {

    @Override
    public StudentDto createDto() {
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
    public StudentEntity createEntity() {
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
}
