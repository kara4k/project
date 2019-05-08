package com.demo.project.unit.test.service;

import com.demo.project.converter.TeacherConverter;
import com.demo.project.repository.TeacherRepository;
import com.demo.project.service.TeacherService;
import com.demo.project.unit.factory.TeacherObjFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TeacherServiceTest extends AbstractServiceTest {

    @InjectMocks
    private TeacherService service;

    @Mock
    private TeacherRepository repository;

    @Spy
    private TeacherConverter converter;

    @Spy
    private TeacherObjFactory objectFactory;

    @Test
    @Override
    public void getAllTest() {
        serviceAsserter.assertGetAll(service, repository, objectFactory);
    }

    @Test
    @Override
    public void getByIdTest() {
        serviceAsserter.assertFindById(service, repository, objectFactory);
    }

    @Test
    @Override
    public void saveTest() {
        serviceAsserter.assertSave(service, repository, objectFactory);
    }

    @Test
    @Override
    public void saveAllTest() {
        serviceAsserter.assertSaveAll(service, repository, objectFactory);
    }

    @Test
    @Override
    public void deleteTest() {
        serviceAsserter.assertDelete(service, repository);
    }

    @Test
    @Override
    public void deleteAllTest() {
        serviceAsserter.assertDeleteAll(service, repository, objectFactory);
    }
}
