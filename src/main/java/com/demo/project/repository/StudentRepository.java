package com.demo.project.repository;

import com.demo.project.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Qualifier;

@Qualifier("StudentRepository")
public interface StudentRepository extends IBaseRepository<StudentEntity> {

}
