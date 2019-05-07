package com.demo.project.unit.test.converter;

import com.demo.project.converter.TeacherConverter;
import com.demo.project.dto.TeacherDto;
import com.demo.project.entity.TeacherEntity;
import com.demo.project.unit.factory.TeacherObjFactory;
import com.demo.project.unit.test.converter.asserters.ConverterTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static com.demo.project.unit.test.converter.asserters.ConverterAsserts.assertConverted;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {TeacherConverter.class, TeacherObjFactory.class})
public class TeacherConverterTest implements ConverterTest<TeacherDto, TeacherEntity> {

    @Autowired
    private TeacherObjFactory objectFactory;

    @Autowired
    private TeacherConverter converter;

    @Test
    @Override
    public void convertToDto() {
        final TeacherEntity entity = objectFactory.createEntity();
        final TeacherDto dto = converter.convertToDto(entity);

        assertConverted(dto, entity);
    }

    @Test
    @Override
    public void convertToEntity() {
        final TeacherDto dto = objectFactory.createDto();
        final TeacherEntity entity = converter.convertToEntity(dto);

        assertConverted(dto, entity);
    }
}
