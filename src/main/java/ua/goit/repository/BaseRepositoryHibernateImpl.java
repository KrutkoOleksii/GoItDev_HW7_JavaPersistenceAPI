package ua.goit.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import ua.goit.model.BaseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class BaseRepositoryHibernateImpl<ID,E extends BaseEntity<ID>> implements BaseRepository<ID,E>{

    private final Class<E> modelClass;

    BaseRepositoryHibernateImpl(Class<E> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public List<E> saveAll(Iterable<E> itrbl) {
        return StreamSupport.stream(itrbl.spliterator(), false)
                .map(element -> save(element))
                .collect(Collectors.toList());
    }

    @Override
    public List<E> findAll() {
        Session session = createSession();
        JpaCriteriaQuery<E> query = session.getCriteriaBuilder().createQuery(modelClass);
        List<E> result = session.createQuery(query.select(query.from(modelClass))).getResultList();
        closeSession(session);
        return result;
    }

    @Override
    public E save(E e) {
        Session session = createSession();
        ID id = (ID) session.save(e);
        Optional<E> optional = findById(id, session);
        closeSession(session);
        return optional.get();
    }

    @Override
    public E getOne(ID id) {
        return findById(id).get();
    }

    @Override
    public Optional<E> findById(ID id) {
        Session session = createSession();
        Optional<E> optional = findById(id, session);
        closeSession(session);
        return optional;
    }

    @Override
    public void deleteById(ID id) {
        Session session = createSession();
        findById(id).ifPresent(session::delete);
        closeSession(session);
    }

    public void close() {
        HibernateSessionFactory.close();
    }

    public Optional<E> findById(ID id, Session session) {
        return Optional.ofNullable(session.get(modelClass,id));
    }

    private Session createSession() {
        Session session = HibernateSessionFactory.createSessionFactory().openSession();
        session.beginTransaction();
        return session;
    }

    private void closeSession(Session session) {
        session.getTransaction().commit();
        session.close();
    }
}
