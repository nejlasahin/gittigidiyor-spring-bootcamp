package spring.bootcamp.client;

import spring.bootcamp.controller.StudentController;
import spring.bootcamp.models.*;
import spring.bootcamp.util.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class HomeworkApiClient {
    public static void main(String[] args) {
        saveTestData();

        StudentController studentController = new StudentController();

        List<Student> studentList = studentController.findAllStudent();
        System.out.println("========== Student List ==========");
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("========== Student Save ==========");
        Student st6 = new Student("St Name 6", LocalDate.of(2000, Month.JANUARY,3), "St Address 6", 'F');
        studentController.saveStudent(st6);

        System.out.println("========== Student Delete ==========");
        studentController.deleteStudent(3);

        System.out.println("========== Student Update ==========");
        Student st7 = new Student("St Name 7", LocalDate.of(2000, Month.DECEMBER,3), "St Address 7", 'M');
        studentController.updateStudent(st7, 1);

        System.out.println("========== Student List By Gender ==========");
        List<Student> studentList2 = studentController.studentListByGender('F');
        for (Student student : studentList2) {
            System.out.println(student);
        }

        System.out.println("========== Student List By Course ==========");
        List<Student> studentList3 = studentController.studentListByCourse(4);
        for (Student student : studentList3) {
            System.out.println(student);
        }
    }

    private static void saveTestData(){
        Instructor per1 = new PermanentInstructor("Per Name 1", "Per Address 1", "12345678", 7000);
        Instructor per2 = new PermanentInstructor("Per Name 2", "Per Address 2", "134324234", 8000);
        Instructor vis1 = new VisitingResearcher("Vis Name 1", "Vis Address 1", "19342678", 200);

        Course course1 = new Course("Java", "J1212", 4);
        Course course2 = new Course("C++", "CP267", 2);
        Course course3 = new Course("Python", "PT912", 6);
        Course course4 = new Course("C#", "CD983", 3);

        course1.setInstructor(per1);
        course2.setInstructor(per2);
        course3.setInstructor(vis1);
        course4.setInstructor(vis1);

        Student st1 = new Student("St Name 1", LocalDate.of(2000, Month.JANUARY,13), "St Address 1", 'F');
        Student st2 = new Student("St Name 2", LocalDate.of(1998, Month.DECEMBER,21), "St Address 2", 'F');
        Student st3 = new Student("St Name 3", LocalDate.of(1999, Month.JULY,3), "St Address 3", 'M');
        Student st4 = new Student("St Name 4", LocalDate.of(2003, Month.APRIL,4), "St Address 4", 'M');
        Student st5 = new Student("St Name 5", LocalDate.of(2001, Month.FEBRUARY,17), "St Address 5", 'M');

        st1.getCourseList().add(course1);
        st2.getCourseList().add(course1);
        st3.getCourseList().add(course1);
        st4.getCourseList().add(course1);
        st5.getCourseList().add(course1);

        st2.getCourseList().add(course2);
        st3.getCourseList().add(course3);
        st4.getCourseList().add(course4);

        course1.getStudentList().add(st1);
        course1.getStudentList().add(st2);
        course1.getStudentList().add(st3);
        course1.getStudentList().add(st4);
        course1.getStudentList().add(st5);

        course1.getStudentList().add(st1);
        course2.getStudentList().add(st2);
        course3.getStudentList().add(st3);
        course4.getStudentList().add(st4);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();

            em.persist(per1);
            em.persist(per2);
            em.persist(vis1);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);
            em.persist(course4);

            em.persist(st1);
            em.persist(st2);
            em.persist(st3);
            em.persist(st4);
            em.persist(st5);


            em.getTransaction().commit();

            System.out.println("All data persisted...");
        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }
    }
}
