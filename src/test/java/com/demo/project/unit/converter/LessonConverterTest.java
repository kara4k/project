package com.demo.project.unit.converter;

import com.demo.project.converter.LessonConverter;
import com.demo.project.converter.StudentConverter;
import com.demo.project.converter.TeacherConverter;
import com.demo.project.dto.LessonDto;
import com.demo.project.dto.StudentDto;
import com.demo.project.entity.LessonEntity;
import com.demo.project.entity.StudentEntity;
import com.demo.project.unit.factory.RandomTestObjectFactory;
import com.demo.project.unit.factory.TestObjectFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Set;

import static com.demo.project.unit.converter.ConverterAsserts.assertConverted;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {LessonConverter.class,
                           TeacherConverter.class,
                           StudentConverter.class,
                           RandomTestObjectFactory.class})
public class LessonConverterTest implements ConverterTest<LessonDto, LessonEntity> {

    @Autowired
    private TestObjectFactory objectFactory;

    @Autowired
    private LessonConverter converter;

    @Test
    @Override
    public void convertToDto() {
        final LessonEntity entity = objectFactory.createLessonEntity();
        final Set<StudentEntity> students = objectFactory.createStudentEntity(3);
        entity.setStudents(students);

        final LessonDto dto = converter.convertToDto(entity);

        assertConverted(dto, entity);
    }

    @Test
    @Override
    public void convertToEntity() {
        final LessonDto dto = objectFactory.createLessonDto();
        final Set<StudentDto> students = objectFactory.createStudentDto(4);
        dto.setStudents(students);

        final LessonEntity entity = converter.convertToEntity(dto);

        assertConverted(dto, entity);
    }
}
