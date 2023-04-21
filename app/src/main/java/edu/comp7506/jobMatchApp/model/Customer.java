package edu.comp7506.jobMatchApp.model;


import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

    private String customerId;

    private String customerName;

    private Long customerTele;

    private String customerEmail;

    private String customerPassword;

    private String customerRegisterTime;

    private Integer status;

    public Customer() {
    }

    public Customer(String customerId, String customerName, Long customerTele, String customerEmail, String customerPassword, String customerRegisterTime, Integer status) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerTele = customerTele;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.customerRegisterTime = customerRegisterTime;
        this.status = status;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Long getCustomerTele() {
        return customerTele;
    }

    public void setCustomerTele(Long customerTele) {
        this.customerTele = customerTele;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public String getCustomerRegisterTime() {
        return customerRegisterTime;
    }

    public void setCustomerRegisterTime(String customerRegisterTime) {
        this.customerRegisterTime = customerRegisterTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
