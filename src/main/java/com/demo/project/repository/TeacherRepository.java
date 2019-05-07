package com.demo.project.repository;

import com.demo.project.entity.TeacherEntity;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("TeacherRepository")
public interface TeacherRepository extends IBaseRepository<TeacherEntity> {
}
