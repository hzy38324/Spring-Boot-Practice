package com.sexycode.springboot.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sexycode.springboot.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
