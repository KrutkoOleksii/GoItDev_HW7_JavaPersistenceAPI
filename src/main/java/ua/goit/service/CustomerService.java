package ua.goit.service;

import ua.goit.model.Customer;

public class CustomerService extends BaseService <Long, Customer>{
    public CustomerService(Class<Customer> aClass) {
        super(aClass);
    }
}
