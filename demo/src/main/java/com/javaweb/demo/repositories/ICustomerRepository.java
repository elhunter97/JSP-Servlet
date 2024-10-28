package com.javaweb.demo.repositories;

import com.javaweb.demo.model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();
}
