package com.demo.project.repository;

import com.demo.project.entity.LessonEntity;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("LessonRepository")
public interface LessonRepository extends IBaseRepository<LessonEntity> {
}
