package com.javaweb.mvc.controller;


import com.javaweb.mvc.dto.StudentDTO;
import com.javaweb.mvc.model.Classroom;
import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.service.IClassService;
import com.javaweb.mvc.service.IStudentService;
import com.javaweb.mvc.service.impl.ClassService;
import com.javaweb.mvc.service.impl.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "student", value = "/student")
public class StudentController extends HttpServlet {
    IStudentService studentService = new StudentService();
    IClassService classService = new ClassService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                List<Classroom> classrooms = classService.findAll();
                req.setAttribute("classrooms", classrooms);
                req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                List<Classroom> classroomsEdit = classService.findAll();
                Student student = studentService.findById(id);
                req.setAttribute("classrooms", classroomsEdit);
                req.setAttribute("student", student);
                req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
                break;
            case "sort":
                String sortby = req.getParameter("sortby");
                List<StudentDTO> studentsSort = studentService.sortByName(sortby);
                req.setAttribute("students", studentsSort);
                req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                break;
            default:
                List<StudentDTO> students = studentService.findAll();
                req.setAttribute("students", students);
                req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                break;
        }

    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String name = req.getParameter("name");
                String address = req.getParameter("address");
                double point = Double.parseDouble(req.getParameter("point"));
                int idClass = Integer.parseInt(req.getParameter("nameclass"));
                Student student = new Student(name, address, point, idClass);
                studentService.save(student);
                resp.sendRedirect("/student");
                break;
            case "delete":
                int id = Integer.parseInt(req.getParameter("id"));
                Boolean isDelete = studentService.deleteById(id);
                if (isDelete) {
                    resp.sendRedirect("/student");
                } else {
                    req.setAttribute("message", "Delete failed");
                    List<StudentDTO> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                }
                break;
            case "search":
                String nameSearch = req.getParameter("searchName");
                if (nameSearch == null) {
                    List<StudentDTO> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                } else {
                    List<StudentDTO> studentsSearch = studentService.findByName(nameSearch);
                    req.setAttribute("students", studentsSearch);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                }
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                String nameEdit = req.getParameter("name");
                String addressEdit = req.getParameter("address");
                double pointEdit = Double.parseDouble(req.getParameter("point"));
                int idClassEdit = Integer.parseInt(req.getParameter("nameclass"));
                Student studentEdit = new Student(idEdit, nameEdit, addressEdit, pointEdit,idClassEdit);
                studentService.update(studentEdit);
                resp.sendRedirect("/student");
                break;
        }

    }
}
