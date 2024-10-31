package com.javaweb.mvc.service;

import com.javaweb.mvc.dto.StudentDTO;
import com.javaweb.mvc.model.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> findAll();

    void save(Student student);

    Boolean deleteById(int id);

    List<StudentDTO> findByName(String nameSearch);

    Student findById(int id);

    void update(Student studentEdit);

    List<StudentDTO> sortByName(String sortby);
}
