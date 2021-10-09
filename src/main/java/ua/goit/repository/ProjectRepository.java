package ua.goit.repository;

import ua.goit.model.Project;

public class ProjectRepository extends BaseRepositoryHibernateImpl<Long, Project>{

    public ProjectRepository(Class<Project> modelClass) {
        super(modelClass);
    }

}
