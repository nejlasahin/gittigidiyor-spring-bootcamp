package spring.bootcamp.week3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week3.model.Student;
import spring.bootcamp.week3.model.StudentGroup;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
    Optional<Student> findByFullName(String fullName);

    @Query("SELECT COUNT(s.id) as count,s.gender as gender FROM Student s GROUP BY s.gender")
    List<StudentGroup> studentGroupByGender();
}
