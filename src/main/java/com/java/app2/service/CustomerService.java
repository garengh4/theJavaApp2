package com.java.app2.service;

import com.java.app2.dto.CustomerDTO;

public interface CustomerService {
    CustomerDTO authenticateCustomer(String emailId, String password) throws Exception;
}
