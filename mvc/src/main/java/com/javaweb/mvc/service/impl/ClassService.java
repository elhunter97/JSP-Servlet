package com.javaweb.mvc.service.impl;

import com.javaweb.mvc.model.Classroom;
import com.javaweb.mvc.repositories.IClassRepository;
import com.javaweb.mvc.repositories.impl.ClassRepository;
import com.javaweb.mvc.service.IClassService;

import java.util.List;

public class ClassService implements IClassService {
    IClassRepository classRepository = new ClassRepository();

    @Override
    public List<Classroom> findAll() {
        return classRepository.findAll();
    }
}
