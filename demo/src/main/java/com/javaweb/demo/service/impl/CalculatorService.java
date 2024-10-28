package com.javaweb.demo.service.impl;

import com.javaweb.demo.service.ICalculatorService;

public class CalculatorService implements ICalculatorService {

    @Override
    public int sum(int a, int b) {
        return a+b;
    }

    @Override
    public double calculate(double a, double b, char operator) {
        switch (operator) {
            case '+':
                return a+b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b != 0) {
                    return a / b;
                } else {
                    throw new RuntimeException("Can not divide by zero");
                }
            default:
                throw new RuntimeException("Invalid operator");
        }
    }
}
