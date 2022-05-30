package com.proyecto.afp.service.impl;

import com.proyecto.afp.model.Customer;
import com.proyecto.afp.repository.CustomerRepository;
import com.proyecto.afp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer create(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer findById(long id) {
        Optional<Customer> op = customerRepository.findById(id);
        return op.isPresent() ? op.get(): new Customer();
    }
}
