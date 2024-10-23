package com.javaweb.demo.controller;

import com.javaweb.demo.service.CalculatorService;
import com.javaweb.demo.service.ICalculatorService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "mainController", value = "/main") // value="/main" means that this servlet will be the default servlet
public class MainController extends HttpServlet {
    private ICalculatorService calculatorService = new CalculatorService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                // tiếp nhận request từ client
        req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp); // chuyển hướng request đến main.jsp
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { // xử lý request từ client
        try { // xử lý ngoại lệ
            int a = Integer.parseInt(req.getParameter("a")); // lấy giá trị của tham số a từ request
            int b = Integer.parseInt(req.getParameter("b"));
            int c = calculatorService.sum(a, b);
            Date today = new Date(); // lấy ngày hiện tại
            req.setAttribute("today", today); // gửi ngày hiện tại về main.jsp
            req.setAttribute("result", c); // gửi kết quả c về main.jsp, phuong thuc setAttribute() giúp gửi dữ liệu từ servlet sang jsp
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req, resp); // chuyển hướng request đến main.jsp
//            resp.sendRedirect(req.getContextPath() + "/main"); // chuyển hướng request đến main.jsp. SendRedirect() giúp chuyển hướng sang một trang khác
        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }
}
