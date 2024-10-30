package com.javaweb.mvc.service;

import com.javaweb.mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<Student> findAll();

    void save(Student student);

    Boolean deleteById(int id);

    List<Student> findByName(String nameSearch);

    Student findById(int id);

    void update(Student studentEdit);

    List<Student> sortByName(String sortby);
}
