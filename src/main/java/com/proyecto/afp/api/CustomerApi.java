package com.proyecto.afp.api;

import com.proyecto.afp.exception.ModeloNotFoundException;
import com.proyecto.afp.model.Customer;
import com.proyecto.afp.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "customers")
public class CustomerApi {

    @Autowired
    CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> findAll(){
        return ResponseEntity.ok(customerService.findAll());
    }


    @PostMapping
    public ResponseEntity<Customer> create(@Valid @RequestBody Customer customer){
        Customer customerResponse = customerService.create(customer);
        return new ResponseEntity<>(customerResponse, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Customer> update(@Valid @RequestBody Customer customer){
        return ResponseEntity.ok(customerService.update(customer));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable("id") long id){
        Customer customer = customerService.findById(id);
        if(customer.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        return ResponseEntity.ok(customerService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") long id){
        Customer customer = customerService.findById(id);
        if(customer.getId() == 0){
            throw  new ModeloNotFoundException("ID no encontrado");
        }
        customerService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
