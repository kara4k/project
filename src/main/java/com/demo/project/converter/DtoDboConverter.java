package com.demo.project.converter;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;

public interface DtoDboConverter<T extends AbstractDto, B extends AbstractEntity> {

    T convertToDto(final B dbo);

    B convertToEntity(final T dto);

}
