package ua.goit.repository;

import ua.goit.model.Developer;

public class DeveloperRepository extends BaseRepositoryHibernateImpl<Long, Developer>{

    public DeveloperRepository(Class<Developer> modelClass) {
        super(modelClass);
    }

}
