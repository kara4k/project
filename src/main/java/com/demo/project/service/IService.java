package com.demo.project.service;

import com.demo.project.dto.AbstractDto;

import java.util.List;
import java.util.Set;

public interface IService<T extends AbstractDto> {

    List<T> findAll();

    T findById(Long id);

    void save(T dto);

    void saveAll(Set<T> dtos);

    void delete(Long id);

    void deleteAll(Set<T> dtos);
}
