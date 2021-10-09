package ua.goit.repository;

import ua.goit.model.Skill;

public class SkillRepository extends BaseRepositoryHibernateImpl<Long, Skill>{

    public SkillRepository(Class<Skill> modelClass) {
        super(modelClass);
    }

}
