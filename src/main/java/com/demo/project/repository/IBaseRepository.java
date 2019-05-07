package com.demo.project.repository;

import com.demo.project.entity.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface IBaseRepository<T extends AbstractEntity> extends JpaRepository<T, Long> {
}
