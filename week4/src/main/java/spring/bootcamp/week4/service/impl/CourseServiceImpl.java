package spring.bootcamp.week4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bootcamp.week4.dto.CourseDto;
import spring.bootcamp.week4.exceptions.CourseIsAlreadyException;
import spring.bootcamp.week4.exceptions.ResourceNotFoundException;
import spring.bootcamp.week4.mapper.CourseMapper;
import spring.bootcamp.week4.model.Course;
import spring.bootcamp.week4.repository.CourseRepository;
import spring.bootcamp.week4.service.CourseService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public CourseDto save(CourseDto courseDto){
        Course course = courseMapper.mapFromCourseDtoToCourse(courseDto);
        if (courseRepository.existsByCourseCode(course.getCourseCode()))
            throw new CourseIsAlreadyException("Course Code with " + course.getCourseCode() + " is already exist.");
        courseRepository.save(course);
        return courseMapper.mapFromCourseToCourseDto(course);
    }

    @Override
    public void update(CourseDto courseDto) {
        Course course = courseMapper.mapFromCourseDtoToCourse(courseDto);
        if (!courseRepository.existsById(course.getId()))
            throw new ResourceNotFoundException("Course Id with " + course.getId() + " not found.");
        if (courseRepository.existsByCourseCode(course.getCourseCode()))
            throw new CourseIsAlreadyException("Course Code with " + course.getCourseCode() + " is already exist.");
        courseRepository.save(course);
    }

    @Override
    public void delete(long id) {
        if (!courseRepository.existsById(id))
            throw new ResourceNotFoundException("Course Id with " + id + " not found.");
        courseRepository.deleteById(id);
    }

    @Override
    public List<CourseDto> findAll() {
        List<Course> courses = courseRepository.findAll();
        return courseMapper.mapFromCoursesToCourseDto(courses);
    }
}
