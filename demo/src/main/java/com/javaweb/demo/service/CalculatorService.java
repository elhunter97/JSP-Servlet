package com.javaweb.demo.service;

public class CalculatorService implements ICalculatorService{

    @Override
    public int sum(int a, int b) {
        return a+b;
    }
}
