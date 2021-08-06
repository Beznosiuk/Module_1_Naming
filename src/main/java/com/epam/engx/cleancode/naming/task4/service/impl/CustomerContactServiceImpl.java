package com.epam.engx.cleancode.naming.task4.service.impl;


import com.epam.engx.cleancode.naming.task4.service.CustomerContactService;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContact;
import com.epam.engx.cleancode.naming.task4.thirdpartyjar.CustomerContactDAO;

public class CustomerContactServiceImpl implements CustomerContactService {

    private final CustomerContactDAO customerContactDAO;

    public CustomerContactServiceImpl(CustomerContactDAO customerContactDAO) {
        this.customerContactDAO = customerContactDAO;
    }

    @Override
    public CustomerContact findById(Long customerId) {
        return customerContactDAO.findById(customerId);
    }

    @Override
    public void update(CustomerContact customerContactDetails) {
        customerContactDAO.updateDetails(customerContactDetails);
    }
}
