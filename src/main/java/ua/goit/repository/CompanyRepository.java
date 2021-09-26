package ua.goit.repository;

import ua.goit.model.Company;

public class CompanyRepository extends BaseRepositoryHibernateImpl<Long, Company>{
    public CompanyRepository(Class<Company> modelClass) {
        super(modelClass);
    }
}
