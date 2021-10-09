package ua.goit.service;

import ua.goit.model.BaseEntity;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.BaseRepositoryHibernateImpl;


import java.util.List;
import java.util.Optional;

public abstract class BaseService <ID, E extends BaseEntity<ID>> {

    private final BaseRepository<ID,E> baseRepositoryHibernate;

    public BaseService(Class<E> aClass){
        this.baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
    }

    public E createEntity(E e) {
        return baseRepositoryHibernate.save(e);
    }

    public E readEntity(ID id) {
        return findById(id).get();
    }

    public E updateEntity(E e) {
        return baseRepositoryHibernate.save(e);
    }

    public void deleteEntity(ID id) {
        baseRepositoryHibernate.deleteById(id);
    }

    public Optional<E> findById(ID id) {
        return Optional.of(baseRepositoryHibernate.getOne(id));
    }

    public List<E> readAll() {
        return baseRepositoryHibernate.findAll();
    }
}
