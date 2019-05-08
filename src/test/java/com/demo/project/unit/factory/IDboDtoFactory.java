package com.demo.project.unit.factory;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;

import java.util.List;
import java.util.Set;

public interface IDboDtoFactory<T extends AbstractDto, B extends AbstractEntity> {

    T createDto();

    B createEntity();

    Set<T> createDtoSet(int size);

    Set<B> createEntitySet(int size);

    List<T> createDtoList(int size);

    List<B> createEntityList(int size);
}
