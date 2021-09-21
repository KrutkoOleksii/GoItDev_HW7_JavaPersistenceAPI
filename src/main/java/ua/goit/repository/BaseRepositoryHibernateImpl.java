package ua.goit.repository;

import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.goit.model.BaseEntity;

import java.util.List;
import java.util.Optional;

public class BaseRepositoryHibernateImpl<ID,E extends BaseEntity<ID>> implements BaseRepository<ID,E>{

    private final Class<E> modelClass;

    BaseRepositoryHibernateImpl(Class<E> modelClass) {
        this.modelClass = modelClass;
    }

    @Override
    public List<E> saveAll(Iterable<E> itrbl) {
        return null;
    }

    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public E save(E e) {
        Session session = createSession();
        Transaction transaction = session.getTransaction();
        E save = (E) session.save(e);
        transaction.commit();
        closeSession(session);
        return save;
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
