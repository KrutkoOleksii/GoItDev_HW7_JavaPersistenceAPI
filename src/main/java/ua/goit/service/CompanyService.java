package ua.goit.service;

import ua.goit.model.Company;

public class CompanyService extends BaseService<Long, Company>{

    public CompanyService(Class<Company> aClass) {
        super(aClass);
    }
}
