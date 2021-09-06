package spring.bootcamp.week3.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week3.model.Instructor;
import spring.bootcamp.week3.model.InstructorOrder;

import java.util.List;
import java.util.Optional;

@Repository
public interface InstructorRepository extends CrudRepository<Instructor, Long> {
    void deleteByFullName(String fullName);

    Optional<Instructor> findByFullName(String fullName);

    @Query(value = "SELECT p.hourly_salary AS salary, i.full_name as name FROM Visiting_Researchers p JOIN Instructors i ON i.id = p.id " +
            "UNION " +
            "SELECT n.fixed_salary as salary,  i.full_name as name FROM Permanent_Instructors n JOIN Instructors i ON i.id = n.id " +
            "ORDER BY salary DESC " +
            "LIMIT 2", nativeQuery = true)
    List<InstructorOrder> orderBySalaryTop3();
}
