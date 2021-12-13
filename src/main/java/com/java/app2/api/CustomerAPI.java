package com.java.app2.api;

import javax.validation.Valid;

import com.java.app2.dto.CustomerDTO;
import com.java.app2.service.CustomerService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping(value="customer-api") //connects to frontend. Check environment.ts in frontend
@Validated
public class CustomerAPI {

    @Autowired
    private CustomerService customerService;

    static Log logger = LogFactory.getLog(CustomerAPI.class);

    @PostMapping(value="/login")
    public ResponseEntity<CustomerDTO> authenticateCustomer(@Valid @RequestBody CustomerDTO customerDTO) throws Exception{
        logger.info("CUSTOMER TRYING TO LOGIN, VALIDATING CREDENTIALS. CUSTOMER EMAILID: "+ customerDTO.getEmailId());
        CustomerDTO customerDTOFromDB = customerService.authenticateCustomer(customerDTO.getEmailId(),customerDTO.getPassword());
        logger.info("CUSTOMER LOGIN SUCCESS. CUSTOMER EMAILID: "+customerDTOFromDB.getEmailId());
        return new ResponseEntity<>(customerDTOFromDB, HttpStatus.OK);
    }

}
