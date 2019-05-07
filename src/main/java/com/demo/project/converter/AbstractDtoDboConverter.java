package com.demo.project.converter;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.data.util.ReflectionUtils;

public abstract class AbstractDtoDboConverter<T extends AbstractDto, B extends AbstractEntity>
    implements DtoDboConverter<T, B> {

    private final Class<T> dtoClass;
    private final Class<B> entityClass;

    public AbstractDtoDboConverter(final Class<T> dtoClass, final Class<B> entityClass) {
        this.dtoClass = dtoClass;
        this.entityClass = entityClass;
    }

    @Override
    public T convertToDto(final B entity) {
        final T dto = ReflectionUtils.createInstanceIfPresent(dtoClass.getName(), null);
        BeanUtils.copyProperties(entity, dto);
        convertToDtoExtras(entity, dto);
        return dto;
    }

    @Override
    public B convertToEntity(final T dto) {
        final B entity = ReflectionUtils.createInstanceIfPresent(entityClass.getName(), null);
        BeanUtils.copyProperties(dto, entity);
        convertToEntityExtras(dto, entity);
        return entity;
    }

    protected void convertToDtoExtras(final B entity, final T dto) {
    }

    protected void convertToEntityExtras(final T dto, final B entity) {
    }
}
