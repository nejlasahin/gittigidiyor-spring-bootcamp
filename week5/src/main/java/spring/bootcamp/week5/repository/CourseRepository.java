package spring.bootcamp.week5.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week5.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByCourseCode(String courseCode);
}
