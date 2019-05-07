package com.demo.project.unit.factory;

import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.TeacherEntity;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("TeacherObjFactory")
public class TeacherObjFactory extends AbstractDboDtoFactory<TeacherDto, TeacherEntity> {

    @Override
    public TeacherDto createDto() {
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
    public TeacherEntity createEntity() {
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
}
