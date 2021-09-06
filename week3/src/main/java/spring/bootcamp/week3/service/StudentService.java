package spring.bootcamp.week3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.bootcamp.week3.model.Student;
import spring.bootcamp.week3.model.StudentGroup;
import spring.bootcamp.week3.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void update(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(long id) {
        studentRepository.deleteById(id);
    }

    public void deleteByFullName(String fullName) {
        Optional<Student> student = this.findByFullName(fullName);
        studentRepository.deleteById(student.get().getId());
    }

    public Optional<Student> findById(long id) {
        return studentRepository.findById(id);
    }

    public Optional<Student> findByFullName(String fullName) {
        return studentRepository.findByFullName(fullName);
    }

    public List<Student> findAll() {
        return (List<Student>) studentRepository.findAll();
    }

    public List<StudentGroup> studentGroupByGender(){
        return studentRepository.studentGroupByGender();
    }
}
