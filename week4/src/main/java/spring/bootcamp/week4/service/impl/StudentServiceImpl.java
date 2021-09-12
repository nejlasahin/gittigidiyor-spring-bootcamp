package spring.bootcamp.week4.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.bootcamp.week4.dto.StudentDto;
import spring.bootcamp.week4.exceptions.ResourceNotFoundException;
import spring.bootcamp.week4.exceptions.StudentAgeNotValidException;
import spring.bootcamp.week4.exceptions.StudentNumberForOneCourseExceededException;
import spring.bootcamp.week4.mapper.StudentMapper;
import spring.bootcamp.week4.model.Student;
import spring.bootcamp.week4.repository.StudentRepository;
import spring.bootcamp.week4.service.StudentService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentMapper studentMapper;
    private final StudentRepository studentRepository;

    @Override
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.mapFromStudentDtoToStudent(studentDto);
        student.getCourses().stream().forEach(
                c -> {
                    if (studentRepository.studentCountByCourse(c.getId()) >= 20) {
                        throw new StudentNumberForOneCourseExceededException("Course Name with " + c.getCourseName() + " student limit exceeded.");
                    }
                }
        );
        if (student.getAge() < 18 || student.getAge() > 40)
            throw new StudentAgeNotValidException("Student age must be between 18 and 40.");
        studentRepository.save(student);
        return studentMapper.mapFromStudentToStudentDto(student);
    }

    @Override
    public void update(StudentDto studentDto) {
        Student student = studentMapper.mapFromStudentDtoToStudent(studentDto);
        if (!studentRepository.existsById(student.getId()))
            throw new ResourceNotFoundException("Student Id with " + student.getId() + " not found.");
        if (student.getAge() < 18 || student.getAge() > 40)
            throw new StudentAgeNotValidException("Student age must be between 18 and 40.");
        student.getCourses().stream().forEach(
                c -> {
                    if (studentRepository.studentCountByCourse(c.getId()) >= 20) {
                        throw new StudentNumberForOneCourseExceededException("Course Name with " + c.getCourseName() + " student limit exceeded.");
                    }
                }
        );
        studentRepository.save(student);
    }

    @Override
    public void delete(long id) {
        if (!studentRepository.existsById(id))
            throw new ResourceNotFoundException("Student Id with " + id + " not found.");
        studentRepository.deleteById(id);
    }

    @Override
    public List<StudentDto> findAll() {
        List<Student> students = studentRepository.findAll();
        return studentMapper.mapFromStudentsToStudentDto(students);
    }
}
