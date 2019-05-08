package com.demo.project.unit.test.service;

import com.demo.project.converter.LessonConverter;
import com.demo.project.repository.LessonRepository;
import com.demo.project.service.LessonService;
import com.demo.project.unit.factory.LessonObjFactory;
import com.demo.project.unit.factory.StudentObjFactory;
import com.demo.project.unit.factory.TeacherObjFactory;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;

@RunWith(MockitoJUnitRunner.class)
public class LessonServiceTest extends AbstractServiceTest {

    @InjectMocks
    private LessonService service;

    @Mock
    private LessonRepository repository;

    @Mock
    private LessonConverter converter;

    private LessonObjFactory objectFactory;

    @Before
    public void setUp() {
        objectFactory = new LessonObjFactory(new TeacherObjFactory(), new StudentObjFactory());
        Mockito.when(converter.convertToDto(Mockito.any())).thenReturn(objectFactory.createDto());
        Mockito.when(converter.convertToEntity(Mockito.any())).thenReturn(objectFactory.createEntity());
    }

    @Override
    @Test
    public void getAllTest() {
        serviceAsserter.assertGetAll(service, repository, objectFactory);

        Mockito.verify(converter, times(1)).convertToDto(Mockito.any());
    }

    @Override
    @Test
    public void getByIdTest() {
        serviceAsserter.assertFindById(service, repository, objectFactory);
    }

    @Override
    @Test
    public void saveTest() {
        serviceAsserter.assertSave(service, repository, objectFactory);
    }

    @Override
    @Test
    public void saveAllTest() {
        serviceAsserter.assertSaveAll(service, repository, objectFactory);
    }

    @Override
    @Test
    public void deleteTest() {
        serviceAsserter.assertDelete(service, repository);
    }

    @Override
    @Test
    public void deleteAllTest() {
        serviceAsserter.assertDeleteAll(service, repository, objectFactory);
    }


}
