package spring.bootcamp.week3.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.bootcamp.week3.model.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {
    Optional<Course> findByCourseName(String courseName);
}
