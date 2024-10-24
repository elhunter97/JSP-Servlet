package com.javaweb.demo.service;

public class ProductService implements IProductService{
    @Override
    public double calculateDiscountAmount(double price, double discountPercent) {
        return price * discountPercent * 0.01;
    }
}
