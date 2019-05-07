package com.demo.project.controller;

import com.demo.project.dto.TeacherDto;
import com.demo.project.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teachers")
public class TeacherController extends AbstractController<TeacherDto>{

    public TeacherController(final IService<TeacherDto> service) {
        super(service);
    }
}
