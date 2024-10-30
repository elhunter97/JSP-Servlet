package com.javaweb.mvc.repositories.impl;

import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.repositories.IStudentRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements IStudentRepository {
    private static List<Student> students;

    static {
        students = new ArrayList<>();
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select * from student");
            ResultSet rs = ps.executeQuery();
            int id;
            String name;
            String address;
            double point;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                students.add(new Student(id, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("insert into student(name,address,point) values(?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getAddress());
            ps.setDouble(3, student.getPoint());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Boolean deleteById(int id) {
        boolean isDelete = false;
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("delete from student where id=?");
            ps.setInt(1, id);
            isDelete = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return isDelete;
    }

    @Override
    public List<Student> findByName(String nameSearch) {
        List<Student> result = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select * from student where name like ?");
            ps.setString(1, "%" + nameSearch + "%");
            ResultSet rs = ps.executeQuery();
            int id;
            String name;
            String address;
            double point;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                result.add(new Student(id, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select * from student where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int idEdit;
            String name;
            String address;
            double point;
            while (rs.next()) {
                idEdit = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                return new Student(idEdit, name, address, point);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    @Override
    public void update(Student studentEdit) {
        Student student = findById(studentEdit.getId());
        if (student != null) {
            try {
                PreparedStatement ps = BaseRepository.getConnection().prepareStatement("update student set name=?,address=?,point=? where id=?");
                ps.setString(1, studentEdit.getName());
                ps.setString(2, studentEdit.getAddress());
                ps.setDouble(3, studentEdit.getPoint());
                ps.setInt(4, studentEdit.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<Student> sortByName(String sortby) {
        List<Student> students = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select * from student order by "+sortby);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                double point = rs.getDouble("point");
                students.add(new Student(id, name, address, point));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
