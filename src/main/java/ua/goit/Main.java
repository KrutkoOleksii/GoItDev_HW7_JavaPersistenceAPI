package ua.goit;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ua.goit.model.Company;
import ua.goit.model.Project;
import ua.goit.repository.BaseRepositoryHibernateImpl;
import ua.goit.repository.HibernateSessionFactory;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
//       HibernateSessionFactory.of(Company.class);
       Session session = HibernateSessionFactory.of().openSession();
       //new BaseRepositoryHibernateImpl(Company.class);

//        Session session = sessionFactory.openSession();
//
//        session.beginTransaction();
//
//        //todo
//
//        session.getTransaction().commit();
//        session.close();

        Company softServe = new Company().builder()
                .name("SoftServe")
                .code("55555555")
                .build();
        Company epam =new Company().builder()
                .name("EPAM")
                .code("88888888")
                .build();

        Set<Project> projects = new HashSet<>();
        Project sirius = new Project().builder()
                .name("Sirius")
                .cost(1_000_000)
                .startDate("2021-05-05")
                .company(softServe)
                .build();
        Project trade = new Project().builder()
                .name("Trade")
                .cost(1_000_000)
                .startDate("2021-05-05")
                .company(softServe)
                .build();
        projects.add(sirius);
        projects.add(trade);

        softServe.setProjects(projects);

        session.save(softServe);
        session.save(epam);

        session.close();

    }
}