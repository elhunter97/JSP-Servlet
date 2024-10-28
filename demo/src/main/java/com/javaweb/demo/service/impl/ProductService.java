package com.javaweb.demo.service.impl;

import com.javaweb.demo.service.IProductService;

public class ProductService implements IProductService {
    @Override
    public double calculateDiscountAmount(double price, double discountPercent) {
        return price * discountPercent * 0.01;
    }
}
