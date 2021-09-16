package spring.bootcamp.week5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week5.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    @Query("SELECT COUNT(s) FROM Student s JOIN s.courses cl WHERE cl.id = :id")
    int studentCountByCourse(long id);
}
