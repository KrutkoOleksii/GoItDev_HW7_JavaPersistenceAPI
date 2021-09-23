package ua.goit.service;

import org.hibernate.Session;
import ua.goit.model.BaseEntity;
import ua.goit.repository.BaseRepositoryHibernateImpl;
import ua.goit.repository.Factory;
import ua.goit.repository.HibernateSessionFactory;

import java.util.Optional;

public abstract class BaseService <ID, E extends BaseEntity<ID>> {

    public E createEntity(Class<E> aClass, E e) {
        //return Factory.of(aClass).save(e);
        //return (E) HibernateSessionFactory.of().openSession().save(e);
        return  (E) HibernateSessionFactory.of().openSession().save(e);
    }

    public E readEntity(Class<E> aClass, ID id) {
        return Factory.of(aClass).getOne(id);
    }

    public E updateEntity(Class<E> aClass, E e) {
        return Factory.of(aClass).save(e);
    }

    public void deleteEntity(Class<E> aClass, ID id) {
        Factory.of(aClass).deleteById(id);
    }

    public Optional<E> findById(Class<E> aClass, ID id) {
        return Factory.of(aClass).findById(id);
    }
}
