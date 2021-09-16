package spring.bootcamp.week5.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.bootcamp.week5.dto.StudentDto;
import spring.bootcamp.week5.enums.Gender;
import spring.bootcamp.week5.mapper.StudentMapper;
import spring.bootcamp.week5.model.Student;
import spring.bootcamp.week5.repository.StudentRepository;
import spring.bootcamp.week5.service.impl.StudentServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentServiceImplTest {

    @Mock
    StudentMapper studentMapper;

    @Mock
    StudentRepository studentRepository;

    @InjectMocks
    StudentServiceImpl studentServiceImpl;

    @Test
    public void saveSuccessfully(){
        Student student = new Student(1L,"Student Name", "Student Address", Gender.FEMALE,18);
        StudentDto studentDto= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        when(studentMapper.mapFromStudentDtoToStudent(studentDto)).thenReturn(student);
        when(studentRepository.save(student)).thenReturn(student);
        when(studentMapper.mapFromStudentToStudentDto(student)).thenReturn(studentDto);

        StudentDto actual = this.studentServiceImpl.save(studentDto);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(studentDto, actual),
                () -> assertEquals(studentDto.getId(),actual.getId())
        );

    }

    @Test
    public void findAllSuccessfully(){
        List<StudentDto> studentDtoList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        Student student1 = new Student(1L,"Student Name 1", "Student Address 1", Gender.FEMALE,18);
        Student student2= new Student(2L,"Student Name 2", "Student Address 2", Gender.MALE,28);
        studentList.add(student1);
        studentList.add(student2);

        StudentDto studentDto1= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);
        StudentDto studentDto2= new StudentDto(2L,"Student Name 2", "Student Address 2", Gender.MALE,28);
        studentDtoList.add(studentDto1);
        studentDtoList.add(studentDto2);

        when(studentRepository.findAll()).thenReturn(studentList);
        when(studentMapper.mapFromStudentsToStudentDto(studentList)).thenReturn(studentDtoList);

        List<StudentDto> studentDtos = this.studentServiceImpl.findAll();

        assertAll(
                () -> assertNotNull(studentDtoList),
                () -> assertEquals(studentDtos, studentDtoList),
                () -> assertEquals(studentDtos.size(), studentDtoList.size())
        );

    }

    @Test
    public void updateSuccessfully(){
        Student student = new Student(1L,"Student Name", "Student Address", Gender.FEMALE,18);
        StudentDto studentDto= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        when(studentMapper.mapFromStudentDtoToStudent(studentDto)).thenReturn(student);
        when(studentRepository.existsById(student.getId())).thenReturn(Boolean.TRUE);
        when(studentRepository.save(student)).thenReturn(student);

        assertDoesNotThrow(
                () -> this.studentServiceImpl.update(studentDto)
        );


    }

    @Test
    public void deleteSuccessfully(){
        Student student = new Student(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        when(studentRepository.existsById(student.getId())).thenReturn(Boolean.TRUE);

        assertDoesNotThrow(
                () -> this.studentServiceImpl.delete(student.getId())
        );
    }
}
