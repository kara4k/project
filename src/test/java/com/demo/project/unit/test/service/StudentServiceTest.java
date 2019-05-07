package com.demo.project.unit.test.service;

import com.demo.project.converter.StudentConverter;
import com.demo.project.repository.StudentRepository;
import com.demo.project.service.StudentService;
import com.demo.project.unit.factory.StudentObjFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceTest extends AbstractServiceTest {


    @InjectMocks
    private StudentService service;

    @Mock
    private StudentRepository repository;

    @Spy
    private StudentConverter converter;

    @Spy
    private StudentObjFactory objectFactory;

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
        serviceAsserter.assertSaveAll(service, repository, objectFactory);
    }
}
