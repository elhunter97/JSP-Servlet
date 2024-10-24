package com.javaweb.demo.controller;

import com.javaweb.demo.service.IProductService;
import com.javaweb.demo.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "product", value = "/product")
public class ProductDiscountCalculator extends HttpServlet {
    IProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/product.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        double price = Double.parseDouble(req.getParameter("price"));
        double discountPercent = Double.parseDouble(req.getParameter("percent"));
        double discountAmount = productService.calculateDiscountAmount(price, discountPercent);
        double discountPrice = price - discountAmount;
        req.setAttribute("description", description);
        req.setAttribute("price", price);
        req.setAttribute("discount_percent", discountPercent);
        req.setAttribute("discount_amount", discountAmount);
        req.setAttribute("discount_price", discountPrice);
        req.getRequestDispatcher("/WEB-INF/views/display-discount.jsp").forward(req, resp);
    }
}
