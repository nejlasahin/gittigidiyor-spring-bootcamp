package spring.bootcamp.week4.service;

import spring.bootcamp.week4.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    void update(StudentDto studentDto);
    void delete(long id);
    List<StudentDto> findAll();
}
