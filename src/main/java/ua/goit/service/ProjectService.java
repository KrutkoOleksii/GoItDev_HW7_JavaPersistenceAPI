package ua.goit.service;

import ua.goit.model.Project;

public class ProjectService extends BaseService<Long, Project>{
    public ProjectService(Class<Project> aClass) {
        super(aClass);
    }

}
