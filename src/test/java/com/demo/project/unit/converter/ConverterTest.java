package com.demo.project.unit.converter;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;

public interface ConverterTest<T extends AbstractDto, B extends AbstractEntity> {

    void convertToDto();

    void convertToEntity();

}
