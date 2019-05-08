package com.demo.project.unit.test.service.asserters;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;
import com.demo.project.repository.IBaseRepository;
import com.demo.project.service.IService;
import com.demo.project.unit.factory.IDboDtoFactory;
import org.junit.Assert;
import org.mockito.Mockito;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.Mockito.times;


public class ServiceAsserter implements IServiceAsserter {

    private static final long TEST_ID = 21L;
    private static final int CALL_COUNT = 2;


    private interface Action {
        void perform();
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertGetAll(final IService<T> service,
                                                                               final IBaseRepository<B> repository,
                                                                               final IDboDtoFactory<T, B> objectFactory) {

        final List<B> entities = objectFactory.createEntityList(1);
        Mockito.when(repository.findAll()).thenReturn(entities);

        final Set<T> dtos = service.findAll();

        Mockito.verify(repository, times(1)).findAll();

        Assert.assertFalse(CollectionUtils.isEmpty(entities));
        Assert.assertEquals(entities.size(), dtos.size());
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertFindById(final IService<T> service,
                                                                                 final IBaseRepository<B> repository,
                                                                                 final IDboDtoFactory<T, B> objectFactory) {

        final B entity = objectFactory.createEntity();

        Mockito.when(repository.findById(TEST_ID)).thenReturn(Optional.of(entity));

        final T dto = service.findById(TEST_ID);

        Mockito.verify(repository, times(1)).findById(TEST_ID);

        Assert.assertNotNull(dto);
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertSave(final IService<T> service,
                                                                             final IBaseRepository<B> repository,
                                                                             final IDboDtoFactory<T, B> objectFactory) {

        final T dto = objectFactory.createDto();

        callTimes(() -> service.save(dto), CALL_COUNT);

        Mockito.verify(repository, times(CALL_COUNT)).saveAll(Mockito.any());
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertSaveAll(final IService<T> service,
                                                                                final IBaseRepository<B> repository,
                                                                                final IDboDtoFactory<T, B> objectFactory) {

        final Set<T> dtos = objectFactory.createDtoSet(4);

        callTimes(() -> service.saveAll(dtos), CALL_COUNT);

        Mockito.verify(repository, times(CALL_COUNT)).saveAll(Mockito.any());
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertDelete(final IService<T> service,
                                                                               final IBaseRepository<B> repository) {

        callTimes(() -> service.delete(TEST_ID), CALL_COUNT);

        Mockito.verify(repository, times(CALL_COUNT)).deleteById(TEST_ID);
    }

    @Override
    public <T extends AbstractDto, B extends AbstractEntity> void assertDeleteAll(final IService<T> service,
                                                                                  final IBaseRepository<B> repository,
                                                                                  final IDboDtoFactory<T, B> objectFactory) {
        final Set<T> dtos = objectFactory.createDtoSet(3);

        callTimes(() -> service.deleteAll(dtos), CALL_COUNT);

        Mockito.verify(repository, times(CALL_COUNT)).deleteAll(Mockito.any());
    }

    private void callTimes(final Action action, final int times) {

        for (int i = 0; i < times; i++) {
            action.perform();
        }
    }
}
