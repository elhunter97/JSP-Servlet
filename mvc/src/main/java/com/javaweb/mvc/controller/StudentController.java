package com.javaweb.mvc.controller;


import com.javaweb.mvc.model.Student;
import com.javaweb.mvc.service.IStudentService;
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                req.getRequestDispatcher("/WEB-INF/views/create.jsp").forward(req, resp);
                break;
            case "edit":
                int id = Integer.parseInt(req.getParameter("id"));
                Student student = studentService.findById(id);
                req.setAttribute("student", student);
                req.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(req, resp);
                break;
            default:
                List<Student> students = studentService.findAll();
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
                Student student = new Student(name, address, point);
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
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                }
                break;
            case "search":
                String nameSearch = req.getParameter("searchName");
                if (nameSearch == null) {
                    List<Student> students = studentService.findAll();
                    req.setAttribute("students", students);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                } else {
                    List<Student> studentsSearch = studentService.findByName(nameSearch);
                    req.setAttribute("students", studentsSearch);
                    req.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(req, resp);
                }
                break;
            case "edit":
                int idEdit = Integer.parseInt(req.getParameter("id"));
                String nameEdit = req.getParameter("name");
                String addressEdit = req.getParameter("address");
                double pointEdit = Double.parseDouble(req.getParameter("point"));
                Student studentEdit = new Student(idEdit, nameEdit, addressEdit, pointEdit);
                studentService.update(studentEdit);
                resp.sendRedirect("/student");
                break;
        }

    }
}
