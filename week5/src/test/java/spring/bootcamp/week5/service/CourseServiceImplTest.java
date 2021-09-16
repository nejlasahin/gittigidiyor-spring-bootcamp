package spring.bootcamp.week5.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.bootcamp.week5.dto.CourseDto;
import spring.bootcamp.week5.mapper.CourseMapper;
import spring.bootcamp.week5.model.Course;
import spring.bootcamp.week5.repository.CourseRepository;
import spring.bootcamp.week5.service.impl.CourseServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CourseServiceImplTest {

    @Mock
    CourseMapper courseMapper;

    @Mock
    CourseRepository courseRepository;

    @InjectMocks
    CourseServiceImpl courseServiceImpl;

    @Test
    public void saveSuccessfully(){
        Course course = new Course(1L, "Java", "JV121", 4);
        CourseDto courseDto= new CourseDto(1L, "Java", "JV121", 4);

        when(courseMapper.mapFromCourseDtoToCourse(courseDto)).thenReturn(course);
        when(courseRepository.existsByCourseCode(course.getCourseCode())).thenReturn(Boolean.FALSE);
        when(courseRepository.save(course)).thenReturn(course);
        when(courseMapper.mapFromCourseToCourseDto(course)).thenReturn(courseDto);

        CourseDto actual = this.courseServiceImpl.save(courseDto);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(courseDto, actual),
                () -> assertEquals(courseDto.getCourseCode(),actual.getCourseCode())
        );

    }

    @Test
    public void findAllSuccessfully(){
        List<CourseDto> courseDtoList = new ArrayList<>();
        List<Course> courseList = new ArrayList<>();

        Course course1 = new Course(1L, "Java", "JV121", 4);
        Course course2 = new Course(2L, "C++", "CP233", 2);
        courseList.add(course1);
        courseList.add(course2);

        CourseDto courseDto1= new CourseDto(1L, "Java", "JV121", 4);
        CourseDto courseDto2 = new CourseDto(2L, "C++", "CP233", 2);
        courseDtoList.add(courseDto1);
        courseDtoList.add(courseDto2);

        when(courseRepository.findAll()).thenReturn(courseList);
        when(courseMapper.mapFromCoursesToCourseDto(courseList)).thenReturn(courseDtoList);

        List<CourseDto> courseDtos = this.courseServiceImpl.findAll();

        assertAll(
                () -> assertNotNull(courseDtoList),
                () -> assertEquals(courseDtos, courseDtoList),
                () -> assertEquals(courseDtos.size(), courseDtoList.size())
        );

    }

    @Test
    public void updateSuccessfully(){
        Course course = new Course(1L, "Java", "JV121", 4);
        CourseDto courseDto= new CourseDto(1L, "Java", "JV121", 4);

        when(courseMapper.mapFromCourseDtoToCourse(courseDto)).thenReturn(course);
        when(courseRepository.existsById(course.getId())).thenReturn(Boolean.TRUE);
        when(courseRepository.existsByCourseCode(course.getCourseCode())).thenReturn(Boolean.FALSE);
        when(courseRepository.save(course)).thenReturn(course);

        assertDoesNotThrow(
                () -> this.courseServiceImpl.update(courseDto)
        );


    }

    @Test
    public void deleteSuccessfully(){
        Course course = new Course(1L, "Java", "JV121", 4);

        when(courseRepository.existsById(course.getId())).thenReturn(Boolean.TRUE);

        assertDoesNotThrow(
            () -> this.courseServiceImpl.delete(course.getId())
        );
    }
}
