package spring.bootcamp.week4.service;

import spring.bootcamp.week4.dto.InstructorDto;

import java.util.List;

public interface InstructorService {
    InstructorDto save(InstructorDto instructorDto);
    void update(InstructorDto instructorDto);
    void delete(long id);
    List<InstructorDto> findAll();
}
