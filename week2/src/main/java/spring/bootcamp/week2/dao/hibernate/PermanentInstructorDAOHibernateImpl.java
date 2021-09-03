package spring.bootcamp.week2.dao.hibernate;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week2.dao.PermanentInstructorDAO;
import spring.bootcamp.week2.model.PermanentInstructor;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class PermanentInstructorDAOHibernateImpl implements PermanentInstructorDAO<PermanentInstructor> {
    private EntityManager entityManager;

    @Autowired
    public PermanentInstructorDAOHibernateImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<PermanentInstructor> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("FROM PermanentInstructor", PermanentInstructor.class).getResultList();
    }

    @Override
    public PermanentInstructor findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        return session.get(PermanentInstructor.class, id);
    }

    @Override
    public PermanentInstructor save(PermanentInstructor permanentInstructor) {
        Session session = entityManager.unwrap(Session.class);
        return (PermanentInstructor) session.merge(permanentInstructor);
    }

    @Override
    public void update(PermanentInstructor permanentInstructor) {
        Session session = entityManager.unwrap(Session.class);
        session.merge(permanentInstructor);

    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(PermanentInstructor.class, id));
    }

    @Override
    public void deleteByObject(PermanentInstructor permanentInstructor) {
        Session session = entityManager.unwrap(Session.class);
        session.delete(session.get(PermanentInstructor.class, permanentInstructor.getId()));
    }
}
