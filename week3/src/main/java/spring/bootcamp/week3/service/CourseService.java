package spring.bootcamp.week3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.bootcamp.week3.model.Course;
import spring.bootcamp.week3.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public Course update(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(long id) {
        courseRepository.deleteById(id);
    }

    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll();
    }

    public Optional<Course> findById(long id) {
        return courseRepository.findById(id);
    }

    public Optional<Course> findByCourseName(String courseName) {
        return  courseRepository.findByCourseName(courseName);
    }

    public void deleteByCourseName(String courseName) {
        Optional<Course> course = this.findByCourseName(courseName);
        courseRepository.deleteById(course.get().getId());
    }

}
