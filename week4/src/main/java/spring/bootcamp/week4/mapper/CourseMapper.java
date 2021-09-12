package spring.bootcamp.week4.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import spring.bootcamp.week4.dto.CourseDto;
import spring.bootcamp.week4.model.Course;

import java.util.List;

@Mapper
public interface CourseMapper {

    Course mapFromCourseDtoToCourse(CourseDto courseDto);

    @Named("mapFromCourseToCourseDto")
    CourseDto mapFromCourseToCourseDto(Course course);

    @IterableMapping(qualifiedByName = "mapFromCourseToCourseDto")
    List<CourseDto> mapFromCoursesToCourseDto(List<Course> courses);
}
