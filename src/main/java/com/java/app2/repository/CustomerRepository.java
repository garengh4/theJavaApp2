package com.java.app2.repository;

import java.util.List;

import com.java.app2.entity.Customer;

import org.springframework.data.repository.CrudRepository;

//crudRepository has built-in classes, hence disimilairity with service. It's being used by service anyways... lols...
public interface CustomerRepository extends CrudRepository<Customer, String>{
    List<Customer> findByPhoneNumber(String phoneNo);
}
