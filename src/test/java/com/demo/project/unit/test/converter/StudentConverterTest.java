package com.demo.project.unit.test.converter;

import com.demo.project.converter.StudentConverter;
import com.demo.project.dto.StudentDto;
import com.demo.project.entity.StudentEntity;
import com.demo.project.unit.factory.StudentObjFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.demo.project.unit.test.converter.asserters.ConverterAsserts.assertConverted;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {StudentConverter.class, StudentObjFactory.class})
public class StudentConverterTest implements ConverterTest<StudentDto, StudentEntity> {

    @Autowired
    private StudentObjFactory objectFactory;

    @Autowired
    private StudentConverter converter;

    @Test
    @Override
    public void convertToDto() {
        final StudentEntity studentEntity = objectFactory.createEntity();
        final StudentDto studentDto = converter.convertToDto(studentEntity);

        assertConverted(studentDto, studentEntity);
    }

    @Test
    @Override
    public void convertToEntity() {
        final StudentDto studentDto = objectFactory.createDto();
        final StudentEntity studentEntity = converter.convertToEntity(studentDto);

        assertConverted(studentDto, studentEntity);
    }

}
