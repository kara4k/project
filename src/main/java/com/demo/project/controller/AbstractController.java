package com.demo.project.controller;

import com.demo.project.dto.AbstractDto;
import com.demo.project.service.IService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


public abstract class AbstractController<T extends AbstractDto> implements IController<T> {

    private final IService<T> service;

    public AbstractController(final IService<T> service) {
        this.service = service;
    }

    @GetMapping("/list")
    public List<T> getAll() {
        return service.findAll();
    }

    @PostMapping("/createOrUpdate")
    public void createNew(@RequestBody final T dto) {
        service.save(dto);
    }

    @PostMapping("/createOrUpdateAll")
    public void createAll(@RequestBody final Set<T> dto) {
        service.saveAll(dto);
    }

    @GetMapping("/{id}")
    public T getSingle(@PathVariable final Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSingle(@PathVariable final Long id) {
        service.delete(id);
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(@RequestBody final Set<T> dtos) {
        service.deleteAll(dtos);
    }
}
