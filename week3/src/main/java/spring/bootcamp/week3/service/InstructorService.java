package spring.bootcamp.week3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.bootcamp.week3.model.Instructor;
import spring.bootcamp.week3.model.InstructorOrder;
import spring.bootcamp.week3.repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    private final InstructorRepository instructorRepository;

    @Autowired
    public InstructorService(InstructorRepository instructorRepository) {
        this.instructorRepository = instructorRepository;
    }

    public void deleteByFullName(String fullName) {
        instructorRepository.deleteByFullName(fullName);
    }

    public void deleteById(long id) {
        instructorRepository.deleteById(id);
    }

    public Optional<Instructor> findById(long id) {
        return instructorRepository.findById(id);
    }

    public void update(Instructor instructor) {
        instructorRepository.save(instructor);
    }

    public Instructor save(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Optional<Instructor> findByFullName(String fullName) {
        return instructorRepository.findByFullName(fullName);
    }

    public List<Instructor> findAll() {
        return (List<Instructor>) instructorRepository.findAll();
    }

    public List<InstructorOrder> orderBySalaryTop3() {
        return (List<InstructorOrder>) instructorRepository.orderBySalaryTop3();
    }
}
