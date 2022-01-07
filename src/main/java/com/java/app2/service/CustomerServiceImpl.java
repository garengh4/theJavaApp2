package com.java.app2.service;


import com.java.app2.dto.CustomerDTO;
import com.java.app2.entity.Customer;
import com.java.app2.exception.EkartException;
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
    public CustomerDTO authenticateCustomer(String emailId, String password) throws EkartException {

        Customer customer = customerRepository.findById(emailId.toLowerCase()).orElseThrow(() -> new EkartException("Service.CUSTOMER_NOT_FOUND"));

        if(!password.equals(customer.getPassword())){
            throw new EkartException("CustomerService.INVALID_CREDENTIALS");
        }

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setEmailId(customer.getEmailId());
        customerDTO.setPassword(customer.getPassword());

        return customerDTO;
    }

    @Override
    public String registerNewCustomer(CustomerDTO customerDTO) throws EkartException {
        String registeredWithEmaiId = null;
        boolean isEmailNotAvailable = customerRepository.findById(customerDTO.getEmailId().toLowerCase()).isEmpty();

        if(isEmailNotAvailable) {
            Customer customer = new Customer();
            customer.setEmailId(customerDTO.getEmailId().toLowerCase());
            customer.setPassword(customerDTO.getPassword());
            customerRepository.save(customer);
            registeredWithEmaiId = customer.getEmailId();
        } else {
            throw new EkartException("CustomerService.EMAIL_ID_ALREADY_IN_USE");
        }
        return registeredWithEmaiId;
    }
    
}
