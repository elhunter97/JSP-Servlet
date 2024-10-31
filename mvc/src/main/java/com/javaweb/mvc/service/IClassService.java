package com.javaweb.mvc.service;

import com.javaweb.mvc.model.Classroom;

import java.util.List;

public interface IClassService {
    List<Classroom> findAll();
}
