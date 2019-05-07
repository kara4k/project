package com.demo.project.controller;

import com.demo.project.dto.StudentDto;
import com.demo.project.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController extends AbstractController<StudentDto>{

    public StudentController(final IService<StudentDto> service) {
        super(service);
    }
}