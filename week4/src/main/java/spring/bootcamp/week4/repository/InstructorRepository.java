package spring.bootcamp.week4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week4.model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {

    boolean existsByPhoneNumber(String phoneNumber);
}
