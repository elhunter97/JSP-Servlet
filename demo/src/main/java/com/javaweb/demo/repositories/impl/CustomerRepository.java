package com.javaweb.demo.repositories.impl;

import com.javaweb.demo.model.Customer;
import com.javaweb.demo.repositories.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {
    private static List<Customer> customers;

    static{
        customers = new ArrayList<>();
        customers.add(new Customer("Han Bao Ngoc","1997-09-14","Ha Noi","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOsVi8hIySuT7PKjAkwDLB_Ye21e8AS5Knpl29KZMaUS2Rrgl8"));
        customers.add(new Customer("Han Bao Ngoc","1997-09-14","Ha Noi","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOsVi8hIySuT7PKjAkwDLB_Ye21e8AS5Knpl29KZMaUS2Rrgl8"));
        customers.add(new Customer("Han Bao Ngoc","1997-09-14","Ha Noi","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOsVi8hIySuT7PKjAkwDLB_Ye21e8AS5Knpl29KZMaUS2Rrgl8"));
        customers.add(new Customer("Han Bao Ngoc","1997-09-14","Ha Noi","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOsVi8hIySuT7PKjAkwDLB_Ye21e8AS5Knpl29KZMaUS2Rrgl8"));
        customers.add(new Customer("Han Bao Ngoc","1997-09-14","Ha Noi","https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcQOsVi8hIySuT7PKjAkwDLB_Ye21e8AS5Knpl29KZMaUS2Rrgl8"));
    }


    @Override
    public List<Customer> findAll() {
        return customers;
    }
}
