package com.javaweb.demo.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "dictionary", value = "/dictionary")
public class Dictionary extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/dictionary.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String vn = "";
        String en = req.getParameter("english");
        switch (en) {
            case "hello":
                vn = "Xin chào";
                break;
            case "goodbye":
                vn = "Tạm biệt";
                break;
            case "love":
                vn = "Yêu";
                break;
                default:
                    vn = "Không có từ này";
                    break;
        }
        req.setAttribute("vietnamese", vn);
        req.getRequestDispatcher("/WEB-INF/views/dictionary.jsp").forward(req, resp);
    }
}
