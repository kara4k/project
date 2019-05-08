package com.demo.project.unit.test.converter;

import com.demo.project.converter.LessonConverter;
import com.demo.project.converter.StudentConverter;
import com.demo.project.converter.TeacherConverter;
import com.demo.project.dto.LessonDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.unit.factory.LessonObjFactory;
import com.demo.project.unit.factory.StudentObjFactory;
import com.demo.project.unit.factory.TeacherObjFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.demo.project.unit.test.converter.asserters.ConverterAsserts.assertConverted;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {LessonConverter.class,
                           TeacherConverter.class,
                           StudentConverter.class,
                           LessonObjFactory.class,
                           TeacherObjFactory.class,
                           StudentObjFactory.class})
public class LessonConverterTest implements ConverterTest<LessonDto, LessonEntity> {

    @Autowired
    private LessonObjFactory objectFactory;

    @Autowired
    private LessonConverter converter;

    @Test
    @Override
    public void convertToDto() {
        final LessonEntity entity = objectFactory.createEntity();
        final LessonDto dto = converter.convertToDto(entity);

        assertConverted(dto, entity);
    }

    @Test
    @Override
    public void convertToEntity() {
        final LessonDto dto = objectFactory.createDto();
        final LessonEntity entity = converter.convertToEntity(dto);

        assertConverted(dto, entity);
    }
}
