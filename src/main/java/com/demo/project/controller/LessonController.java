package com.demo.project.controller;

import com.demo.project.dto.LessonDto;
import com.demo.project.service.IService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/lessons")
public class LessonController extends AbstractController<LessonDto> {

    public LessonController(final IService<LessonDto> service) {
        super(service);
    }
}
