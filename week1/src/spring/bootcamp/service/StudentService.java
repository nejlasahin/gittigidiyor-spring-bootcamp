package spring.bootcamp.service;


import javax.persistence.EntityManager;

import spring.bootcamp.models.Student;
import spring.bootcamp.repository.CrudRepository;
import spring.bootcamp.repository.StudentRepository;
import spring.bootcamp.util.EntityManagerUtils;
import java.util.List;

public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("FROM Student", Student.class).getResultList();
    }

    @Override
    public void saveToDatabase(Student student) {
        try{
            em.getTransaction().begin();
            em.persist(student);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void deleteFromDatabase(int id) {
        try {
            em.getTransaction().begin();
            Student foundStudent = em.find(Student.class, id);
            em.remove(foundStudent);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public void updateOnDatabase(Student student, int id) {
        try {
            em.getTransaction().begin();
            Student foundStudent = em.find(Student.class, id);
            foundStudent.setAddress(student.getAddress());
            foundStudent.setName(student.getName());
            foundStudent.setBirthDate(student.getBirthDate());
            em.merge(foundStudent);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }

    @Override
    public List<Student> studentListByGender(char gender) {
        return em.createQuery("FROM Student s WHERE s.gender = :gender", Student.class).setParameter("gender", gender).getResultList();
    }

    @Override
    public List studentListByCourse(int courseId) {
        return em.createQuery("SELECT s FROM Student s JOIN s.courseList cl WHERE cl.id = :id", Student.class).setParameter("id", courseId).getResultList();
    }
}
