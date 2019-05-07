package com.demo.project.unit.test.service.asserters;

import com.demo.project.dto.AbstractDto;
import com.demo.project.entity.AbstractEntity;
import com.demo.project.repository.IBaseRepository;
import com.demo.project.service.IService;
import com.demo.project.unit.factory.DboDtoFactory;

public interface IServiceAsserter {
    <T extends AbstractDto, B extends AbstractEntity> void assertGetAll(IService<T> service,
                                                                        IBaseRepository<B> repository,
                                                                        DboDtoFactory<T, B> objectFactory);

    <T extends AbstractDto, B extends AbstractEntity> void assertFindById(IService<T> service,
                                                                          IBaseRepository<B> repository,
                                                                          DboDtoFactory<T, B> objectFactory);

    <T extends AbstractDto, B extends AbstractEntity> void assertSave(IService<T> service,
                                                                      IBaseRepository<B> repository,
                                                                      DboDtoFactory<T, B> objectFactory);

    <T extends AbstractDto, B extends AbstractEntity> void assertSaveAll(IService<T> service,
                                                                         IBaseRepository<B> repository,
                                                                         DboDtoFactory<T, B> objectFactory);

    <T extends AbstractDto, B extends AbstractEntity> void assertDelete(IService<T> service,
                                                                        IBaseRepository<B> repository);

    <T extends AbstractDto, B extends AbstractEntity> void assertDeleteAll(IService<T> service,
                                                                           IBaseRepository<B> repository,
                                                                           DboDtoFactory<T, B> objectFactory);
}
