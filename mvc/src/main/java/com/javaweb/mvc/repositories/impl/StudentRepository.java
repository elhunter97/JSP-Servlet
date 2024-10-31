package com.javaweb.mvc.repositories.impl;

import com.javaweb.mvc.dto.StudentDTO;
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
    public List<StudentDTO> findAll() {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("select student.id,student.name,address,point,c.name as nameClass from student join classroom c on student.id_Class = c.id");
            ResultSet rs = ps.executeQuery();
            int id;
            String name;
            String address;
            double point;
            String nameClass;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                nameClass = rs.getString("nameClass");
                students.add(new StudentDTO(id, name, address, point,nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return students;
    }

    @Override
    public void save(Student student) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().prepareStatement("insert into student(name,address,point,id_Class) values(?,?,?,?)");
            ps.setString(1, student.getName());
            ps.setString(2, student.getAddress());
            ps.setDouble(3, student.getPoint());
            ps.setInt(4,student.getId_Class());
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
    public List<StudentDTO> findByName(String nameSearch) {
        List<StudentDTO> result = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().
                    prepareStatement("select student.id,student.name,address,point,c.name as nameClass from student join classroom c on student.id_Class = c.id where student.name like ?");
            ps.setString(1, "%" + nameSearch + "%");
            ResultSet rs = ps.executeQuery();
            int id;
            String name;
            String address;
            double point;
            String nameClass;
            while (rs.next()) {
                id = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                nameClass= rs.getString("nameClass");
                result.add(new StudentDTO(id, name, address, point,nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    @Override
    public Student findById(int id) {
        try {
            PreparedStatement ps = BaseRepository.getConnection().
                    prepareStatement("select * from student where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            int idEdit;
            String name;
            String address;
            double point;
            int idClass;
            while (rs.next()) {
                idEdit = rs.getInt("id");
                name = rs.getString("name");
                address = rs.getString("address");
                point = rs.getDouble("point");
                idClass = rs.getInt("id_Class");
                return new Student(idEdit, name, address, point,idClass);
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
                PreparedStatement ps = BaseRepository.getConnection().prepareStatement("update student set name=?,address=?,point=?,id_Class=? where id=?");
                ps.setString(1, studentEdit.getName());
                ps.setString(2, studentEdit.getAddress());
                ps.setDouble(3, studentEdit.getPoint());
                ps.setInt(4, studentEdit.getId_Class());
                ps.setInt(5, studentEdit.getId());
                ps.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public List<StudentDTO> sortByName(String sortby) {
        List<StudentDTO> students = new ArrayList<>();
        try {
            PreparedStatement ps = BaseRepository.getConnection().
                    prepareStatement("select student.id,student.name,address,point,c.name as nameClass from student join classroom c on student.id_Class = c.id\n" +
                            "    order by "+sortby);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                double point = rs.getDouble("point");
                String nameClass = rs.getString("nameClass");
                students.add(new StudentDTO(id, name, address, point,nameClass));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return students;
    }
}
