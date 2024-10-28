package com.javaweb.mvc.service.impl;

import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.repositories.IStudentRepository;
import com.javaweb.mvc.repositories.impl.StudentRepository;
import com.javaweb.mvc.service.IStudentService;

import java.util.List;

public class StudentService implements IStudentService {
    IStudentRepository studentRepository = new StudentRepository();
    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
}
