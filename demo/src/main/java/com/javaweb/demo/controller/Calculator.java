package com.javaweb.demo.controller;

import com.javaweb.demo.service.ICalculatorService;
import com.javaweb.demo.service.impl.CalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "calculator", value = "/calculator")
public class Calculator extends HttpServlet {
    ICalculatorService calculatorService = new CalculatorService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/calculator.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        double a = Double.parseDouble(req.getParameter("a"));
        double b = Double.parseDouble(req.getParameter("b"));
        char operator = req.getParameter("operator").charAt(0);
        if (b == 0 && operator == '/') {
            req.setAttribute("result", "Can not divide by zero");
        } else {
            req.setAttribute("result", calculatorService.calculate(a, b, operator));
        }
        req.getRequestDispatcher("/WEB-INF/views/calculator.jsp").forward(req, resp);
    }
}
