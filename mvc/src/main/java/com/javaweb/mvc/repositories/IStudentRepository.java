package com.javaweb.mvc.repositories;

import com.javaweb.mvc.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> findAll();
}
