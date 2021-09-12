package spring.bootcamp.week4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bootcamp.week4.dto.InstructorDto;
import spring.bootcamp.week4.exceptions.InstructorIsAlreadyExistException;
import spring.bootcamp.week4.exceptions.ResourceNotFoundException;
import spring.bootcamp.week4.mapper.InstructorMapper;
import spring.bootcamp.week4.model.Instructor;
import spring.bootcamp.week4.repository.InstructorRepository;
import spring.bootcamp.week4.service.InstructorService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorServiceImpl implements InstructorService {

    private final InstructorMapper instructorMapper;
    private final InstructorRepository instructorRepository;


    @Override
    public InstructorDto save(InstructorDto instructorDto) {
        Instructor instructor = instructorMapper.instructorDtoToInstructor(instructorDto);
        if (instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber()))
            throw new InstructorIsAlreadyExistException("Phone Number with " + instructor.getPhoneNumber() + " is already exist.");
        instructorRepository.save(instructor);
        return instructorMapper.instructorToInstructorDto(instructor);
    }

    @Override
    public void update(InstructorDto instructorDto) {
        Instructor instructor = instructorMapper.instructorDtoToInstructor(instructorDto);
        if (!instructorRepository.existsById(instructor.getId()))
            throw new ResourceNotFoundException("Instructor Id with " + instructor.getId() + " not found.");
        if (instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber()))
            throw new InstructorIsAlreadyExistException("Phone Number with " + instructor.getPhoneNumber() + " is already exist.");
        instructorRepository.save(instructor);
    }

    @Override
    public void delete(long id) {
        if (!instructorRepository.existsById(id))
            throw new ResourceNotFoundException("Instructor Id with " + id + " not found.");
        instructorRepository.deleteById(id);
    }

    @Override
    public List<InstructorDto> findAll() {
        List<Instructor> instructors = instructorRepository.findAll();
        return instructorMapper.mapFromInstructorsToInstructorDto(instructors);
    }
}
