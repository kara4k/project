package com.demo.project.unit.test.service;

import org.junit.Test;

public interface IServiceTest {
    @Test
    void getAllTest();

    @Test
    void getByIdTest();

    @Test
    void saveTest();

    @Test
    void saveAllTest();

    @Test
    void deleteTest();

    @Test
    void deleteAllTest();
}
