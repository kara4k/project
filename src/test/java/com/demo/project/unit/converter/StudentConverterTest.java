package com.demo.project.unit.converter;

import com.demo.project.converter.StudentConverter;
import com.demo.project.dto.StudentDto;
import com.demo.project.entity.StudentEntity;
import com.demo.project.unit.factory.RandomTestObjectFactory;
import com.demo.project.unit.factory.TestObjectFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.demo.project.unit.converter.ConverterAsserts.assertConverted;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StudentConverter.class, RandomTestObjectFactory.class})
public class StudentConverterTest implements ConverterTest<StudentDto, StudentEntity> {

    @Autowired
    private TestObjectFactory objectFactory;

    @Autowired
    private StudentConverter converter;

    @Test
    @Override
    public void convertToDto() {
        final StudentEntity studentEntity = objectFactory.createStudentEntity();
        final StudentDto studentDto = converter.convertToDto(studentEntity);

        assertConverted(studentDto,studentEntity);
    }

    @Test
    @Override
    public void convertToEntity() {
        final StudentDto studentDto = objectFactory.createStudentDto();
        final StudentEntity studentEntity = converter.convertToEntity(studentDto);

        assertConverted(studentDto, studentEntity);
    }

}
