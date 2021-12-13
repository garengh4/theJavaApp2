package com.java.app2.service;


import com.java.app2.dto.CustomerDTO;
import com.java.app2.entity.Customer;
import com.java.app2.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value="customerService") //name of interface
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public CustomerDTO authenticateCustomer(String emailId, String password) throws Exception {

        Customer customer = customerRepository.findById(emailId.toLowerCase()).orElseThrow(() -> new Exception("CUSTOMER NOT FOUND"));

        if(!password.equals(customer.getPassword())){
            throw new Exception("INVALID CREDENTIALS");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setPassword(customer.getPassword());
        customerDTO.setPhoneNo(customer.getPhoneNumber());

        return customerDTO;
    }
    
}
