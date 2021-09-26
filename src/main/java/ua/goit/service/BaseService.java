package ua.goit.service;

import ua.goit.model.BaseEntity;
import ua.goit.repository.BaseRepository;
import ua.goit.repository.BaseRepositoryHibernateImpl;


import java.util.Optional;

public abstract class BaseService <ID, E extends BaseEntity<ID>> {

    public E createEntity(Class<E> aClass, E e) {
        BaseRepository<ID,E> baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
        E save = baseRepositoryHibernate.save(e);
        return save;
    }

    public E readEntity(Class<E> aClass, ID id) {
//        BaseRepository<ID,E> baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
//        E e = baseRepositoryHibernate.getOne(id);
        Optional<E> optional = findById(aClass, id);
        return optional.get();
    }

    public E updateEntity(Class<E> aClass, E e) {
        BaseRepository<ID,E> baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
        E update = baseRepositoryHibernate.save(e);
        return update;
    }

    public void deleteEntity(Class<E> aClass, ID id) {
        BaseRepository<ID,E> baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
        baseRepositoryHibernate.deleteById(id);
    }

    public Optional<E> findById(Class<E> aClass, ID id) {
        BaseRepository<ID,E> baseRepositoryHibernate = new BaseRepositoryHibernateImpl(aClass);
        E e = baseRepositoryHibernate.getOne(id);
        return Optional.of(e);
    }
}
