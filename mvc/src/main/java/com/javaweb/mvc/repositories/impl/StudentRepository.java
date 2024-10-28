package com.javaweb.mvc.repositories.impl;

import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.repositories.IStudentRepository;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
        students.add(new Student(1, "Hán Bảo Ngọc", "Hà Nội", 9.0));
        students.add(new Student(2, "Trần Khánh Linh", "Bắc Ninh", 8.0));
        students.add(new Student(3, "Hán Huệ Liên", "Hà Nội", 7.5));
        students.add(new Student(4, "Kiều Anh Vũ", "Hà Nội", 8.5));
        students.add(new Student(5, "Kiều Gia Hân", "Hà Nội", 9.9));
        students.add(new Student(6, "Kiều Bảo San", "Hà Nội", 6.5));
        students.add(new Student(7, "Hán Trần Hạo Sơn", "Hà Nội", 9.5));

    }

    @Override
    public List<Student> findAll() {
        return students;
    }

    @Override
    public void save(Student student) {
        student.setId(students.get(students.size() - 1).getId() + 1);
        students.add(student);
    }

    @Override
    public Boolean deleteById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Student> findByName(String nameSearch) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().trim().toLowerCase().contains(nameSearch.trim().toLowerCase())) {
                result.add(student);
            }
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }

    @Override
    public void update(Student studentEdit) {
        for (Student student : students) {
            if (student.getId() == studentEdit.getId()) {
                student.setName(studentEdit.getName());
                student.setAddress(studentEdit.getAddress());
                student.setPoint(studentEdit.getPoint());
            }
        }
    }
}
