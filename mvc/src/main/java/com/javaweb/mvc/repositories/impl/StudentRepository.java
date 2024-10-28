package com.javaweb.mvc.repositories.impl;

import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students;
    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Hán Bảo Ngọc", "Hà Nội",9.0));
        students.add(new Student(2, "Trần Khánh Linh", "Bắc Ninh",8.0));
        students.add(new Student(3, "Hán Huệ Liên", "Hà Nội",7.5));
        students.add(new Student(4, "Kiều Anh Vũ", "Hà Nội",8.5));
        students.add(new Student(5, "Kiều Gia Hân", "Hà Nội",9.9));
        students.add(new Student(6, "Kiều Bảo San", "Hà Nội",6.5));
        students.add(new Student(7, "Hán Trần Hạo Sơn", "Hà Nội",9.5));

    }
    @Override
    public List<Student> findAll() {
        return students;
    }
}
