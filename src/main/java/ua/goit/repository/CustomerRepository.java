package ua.goit.repository;

import ua.goit.model.Customer;

public class CustomerRepository extends BaseRepositoryHibernateImpl<Long, Customer>{
    public CustomerRepository(Class<Customer> modelClass) {
        super(modelClass);
    }
}
