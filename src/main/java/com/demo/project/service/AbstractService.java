package com.demo.project.service;

import com.demo.project.converter.DtoDboConverter;
import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;
import com.demo.project.exception.NotFoundException;
import com.demo.project.repository.IBaseRepository;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public abstract class AbstractService<T extends AbstractDto, B extends AbstractEntity> implements IService<T> {

    private final IBaseRepository<B> repository;
    private final DtoDboConverter<T, B> converter;

    public AbstractService(final IBaseRepository<B> repository, final DtoDboConverter<T, B> converter) {
        this.repository = repository;
        this.converter = converter;
    }

    protected abstract String getNotFoundMessage(Long id);

    @Override
    public List<T> findAll() {
        return repository.findAll().stream()
            .map(converter::convertToDto)
            .collect(Collectors.toList());
    }

    @Override
    public T findById(final Long id) {
        return converter.convertToDto(
            repository.findById(id)
                .orElseThrow(() -> new NotFoundException(getNotFoundMessage(id))));
    }

    @Override
    public void save(final T dto) {
        saveAll(Collections.singleton(dto));
    }

    @Override
    public void saveAll(final Set<T> dtos) {
        repository.saveAll(
            dtos.stream()
                .map(converter::convertToEntity)
                .collect(Collectors.toSet()));
    }

    @Override
    public void delete(final Long id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteAll(final Set<T> dtos) {
        repository.deleteAll(
            dtos.stream()
                .map(converter::convertToEntity)
                .collect(Collectors.toSet()));
    }

}
