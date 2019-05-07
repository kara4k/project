package com.demo.project.unit.factory;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public abstract class AbstractDboDtoFactory<T extends AbstractDto, B extends AbstractEntity>
    implements DboDtoFactory<T, B> {

    @Override
    public Set<T> createDtoSet(final int size) {
        return createSet(this::createDto, size);
    }

    @Override
    public Set<B> createEntitySet(final int size) {
        return createSet(this::createEntity, size);
    }

    @Override
    public List<T> createDtoList(final int size) {
        final Set<T> set = createDtoSet(size);
        return new ArrayList<>(set);
    }

    @Override
    public List<B> createEntityList(final int size) {
        final Set<B> set = createEntitySet(size);
        return new ArrayList<>(set);
    }

    String randomString() {
        return RandomStringUtils.randomAlphanumeric(5, 11);
    }

    private <V> Set<V> createSet(final Supplier<V> supplier, final int size) {
        final Set<V> set = new HashSet<>(size);

        for (int i = 0; i < size; i++) {
            set.add(supplier.get());
        }

        return set;
    }
}
