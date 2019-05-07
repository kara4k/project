package com.demo.project.unit.factory;

import com.demo.project.consts.Status;
import com.demo.project.dto.LessonDto;
import com.demo.project.entity.LessonEntity;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;

@Component
@Qualifier("LessonObjFactory")
public class LessonObjFactory extends AbstractDboDtoFactory<LessonDto, LessonEntity> {

    private final TeacherObjFactory teacherObjFactory;
    private final StudentObjFactory studentObjFactory;

    public LessonObjFactory(final TeacherObjFactory teacherObjFactory,
                            final StudentObjFactory studentObjFactory) {
        this.teacherObjFactory = teacherObjFactory;
        this.studentObjFactory = studentObjFactory;
    }

    @Override
    public LessonDto createDto() {
        final LessonDto lessonDto = new LessonDto();
        lessonDto.setId(RandomUtils.nextLong());
        lessonDto.setStartDate(new Date());
        lessonDto.setFinishDate(new Date());
        lessonDto.setPrice(new BigDecimal(RandomUtils.nextDouble(0d, 1000.99)));
        lessonDto.setTopic(randomString());
        lessonDto.setStatus(randomStatus());
        lessonDto.setDescription(randomString());
        lessonDto.setTeacher(teacherObjFactory.createDto());
        lessonDto.setStudents(Collections.singleton(studentObjFactory.createDto()));

        return lessonDto;
    }

    @Override
    public LessonEntity createEntity() {
        final LessonEntity lessonEntity = new LessonEntity();
        lessonEntity.setId(RandomUtils.nextLong());
        lessonEntity.setStartDate(new Date());
        lessonEntity.setFinishDate(new Date());
        lessonEntity.setPrice(new BigDecimal(RandomUtils.nextDouble(0d, 1000.99)));
        lessonEntity.setTopic(randomString());
        lessonEntity.setStatus(randomStatus());
        lessonEntity.setDescription(randomString());
        lessonEntity.setTeacher(teacherObjFactory.createEntity());
        lessonEntity.setStudents(Collections.singleton(studentObjFactory.createEntity()));

        return lessonEntity;
    }

    private Status randomStatus() {
        final Status[] values = Status.values();
        return values[RandomUtils.nextInt(0, values.length)];
    }
}
