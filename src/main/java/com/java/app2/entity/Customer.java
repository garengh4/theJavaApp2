package com.java.app2.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//links to repository
@Entity
@Table(name="EK_CUSTOMER")
public class Customer {
    @Id
    @Column(name="EMAIL_ID")
    private String emailId;

    @Column(name="PASSWORD")
    private String password;


    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }   
    
}
