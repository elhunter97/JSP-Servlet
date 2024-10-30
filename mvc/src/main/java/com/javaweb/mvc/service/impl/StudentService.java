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

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Boolean deleteById(int id) {
        return studentRepository.deleteById(id);
    }

    @Override
    public List<Student> findByName(String nameSearch) {
        return studentRepository.findByName(nameSearch);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public void update(Student studentEdit) {
        studentRepository.update(studentEdit);
    }

    @Override
    public List<Student> sortByName(String sortby) {
        return studentRepository.sortByName(sortby);
    }
}
