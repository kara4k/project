package com.demo.project.unit.test.service;

import com.demo.project.unit.test.service.asserters.ServiceAsserter;
import org.mockito.Spy;


abstract class AbstractServiceTest implements IServiceTest {

    @Spy
    ServiceAsserter serviceAsserter;

}
