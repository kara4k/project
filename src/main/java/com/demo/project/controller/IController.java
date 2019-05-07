package com.demo.project.controller;

import com.demo.project.dto.AbstractDto;

import java.util.Set;

public interface IController<T extends AbstractDto> {

    Set<T> getAll();

    void createNew(final T dto);

    void createAll(final Set<T> dtos);

    T getSingle(final Long id);

    void deleteSingle(final Long id);

    void deleteAll(final Set<T> dtos);

}
