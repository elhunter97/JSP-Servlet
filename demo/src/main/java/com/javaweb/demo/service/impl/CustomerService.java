package com.javaweb.demo.service.impl;

import com.javaweb.demo.model.Customer;
import com.javaweb.demo.repositories.ICustomerRepository;
import com.javaweb.demo.repositories.impl.CustomerRepository;
import com.javaweb.demo.service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
    ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
