package com.javaweb.demo.service;

import com.javaweb.demo.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();
}
