package com.javaweb.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String message = "";
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username.equals("admin") && password.equals("admin")) {
            message = "Login success";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/views/money.jsp").forward(req, resp);
        } else {
            message = "Login failed";
            req.setAttribute("message", message);
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
    }
}
