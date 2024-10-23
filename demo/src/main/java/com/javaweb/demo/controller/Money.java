package com.javaweb.demo.controller;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "money", value = "/money")
public class Money extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/money.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int money = 0;
        int usd = Integer.parseInt(req.getParameter("usd"));
        money = usd * 23000;
        req.setAttribute("vnd", money);
        req.getRequestDispatcher("/WEB-INF/views/money.jsp").forward(req, resp);
    }
}
