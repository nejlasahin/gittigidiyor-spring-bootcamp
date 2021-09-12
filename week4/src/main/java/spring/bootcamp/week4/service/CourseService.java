package spring.bootcamp.week4.service;

import spring.bootcamp.week4.dto.CourseDto;

import java.util.List;

public interface CourseService {
    CourseDto save(CourseDto courseDto);
    void update(CourseDto courseDto);
    void delete(long id);
    List<CourseDto> findAll();
}
