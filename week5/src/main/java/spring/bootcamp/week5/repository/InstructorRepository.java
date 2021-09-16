package spring.bootcamp.week5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week5.model.Instructor;
import spring.bootcamp.week5.model.abstracts.InstructorSalary;

import javax.transaction.Transactional;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    boolean existsByPhoneNumber(String phoneNumber);


    @Query(value = "SELECT p.hourly_salary AS salary, i.type as type FROM Visiting_Researchers p JOIN Instructors i ON i.id = p.id " +
            "UNION " +
            "SELECT n.fixed_salary as salary,  i.type as type FROM Permanent_Instructors n JOIN Instructors i ON i.id = n.id " +
            "WHERE i.id= :id", nativeQuery = true)
    InstructorSalary getSalaryAndType(long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Permanent_Instructors SET fixed_salary= :salary WHERE id= :id" , nativeQuery = true)
    void updatePermanentInstructor(double salary, long id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Visiting_Researchers SET hourly_salary = :salary WHERE id= :id" , nativeQuery = true)
    void updateVisitingResearcher(double salary, long id);
}
