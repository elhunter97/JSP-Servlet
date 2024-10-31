package com.javaweb.mvc.repositories;

import com.javaweb.mvc.model.Classroom;

import java.util.List;

public interface IClassRepository {
    List<Classroom> findAll();
}
