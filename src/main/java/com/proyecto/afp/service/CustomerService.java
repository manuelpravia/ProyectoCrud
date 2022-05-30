package com.proyecto.afp.service;

import com.proyecto.afp.model.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> findAll();

    Customer create(Customer customer);

    Customer update(Customer customer);

    void delete(long id);

    Customer findById(long id);
}
