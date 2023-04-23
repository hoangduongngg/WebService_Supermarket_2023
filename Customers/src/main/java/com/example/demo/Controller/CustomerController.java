/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.Controller;

import com.example.demo.Model.Customer;
import com.example.demo.Model.CustomerDTO;
import com.example.demo.Repository.CustomerRepository;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author ben
 */
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    @ResponseBody
    public ResponseEntity<List<Customer>> getAll() {
        List<Customer> listCustomer = customerRepository.findAll();
        if (listCustomer.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(listCustomer);
        }
    }

    @GetMapping("/customer")
    @ResponseBody
    public ResponseEntity<Customer> getById(@RequestParam Integer id) {
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return ResponseEntity.ok(customer.get());
        } else {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
    }

    @PostMapping("/add-customer")
    @ResponseBody
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        Optional<Customer> customer = customerRepository.findByPhoneNumber(customerDTO.phoneNumber);
        if (customer.isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            Customer addCustomer = new Customer(customerDTO);
            customerRepository.save(addCustomer);
            return ResponseEntity.ok(addCustomer);
        }

    }
    
    @PostMapping("/update-customer")
    @ResponseBody
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDTO customerDTO) throws ParseException {
        Optional<Customer> customer = customerRepository.findById(customerDTO.id);
        if (customer.isPresent()) {
            Customer addCustomer = new Customer(customerDTO);
            customerRepository.save(addCustomer);
            return ResponseEntity.ok(addCustomer);
            
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    
    @DeleteMapping("/delete-customer")
    @ResponseBody
    public ResponseEntity<Customer> deleteCustomer(@RequestParam Integer id){
        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            customerRepository.deleteById(id);
            return ResponseEntity.ok(customer.get());
            
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
    
    @GetMapping("/search-customer")
    @ResponseBody
    public ResponseEntity<List<Customer>> searchByKeyword(@RequestParam String keyword) {
        List<Customer> listCustomer = customerRepository.findByNameContainingIgnoreCase(keyword);
        if (listCustomer.size() == 0) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.ok(listCustomer);
        }
    }

}
