package com.java.app2.service;

import com.java.app2.dto.CustomerDTO;
import com.java.app2.exception.EkartException;

public interface CustomerService {
    
    CustomerDTO authenticateCustomer(String emailId, String password) throws EkartException;

    String registerNewCustomer(CustomerDTO customerDTO) throws EkartException;
}
