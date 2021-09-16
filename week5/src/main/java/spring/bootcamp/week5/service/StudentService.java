package spring.bootcamp.week5.service;

import spring.bootcamp.week5.dto.StudentDto;

import java.util.List;

public interface StudentService {
    StudentDto save(StudentDto studentDto);
    void update(StudentDto studentDto);
    void delete(long id);
    List<StudentDto> findAll();
}
