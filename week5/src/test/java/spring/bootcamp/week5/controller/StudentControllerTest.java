package spring.bootcamp.week5.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.bootcamp.week5.dto.StudentDto;
import spring.bootcamp.week5.enums.Gender;
import spring.bootcamp.week5.service.StudentService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    StudentService studentService;

    @InjectMocks
    StudentController studentController;

    @Test
    void saveSuccessfully(){
        StudentDto studentDto= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        when(studentService.save(studentDto)).thenReturn(studentDto);

        ResponseEntity<StudentDto> actual = this.studentController.save(studentDto);

        assertAll(
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(studentDto.getId(), actual.getBody().getId()),
                () -> assertEquals(studentDto, actual.getBody()),
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void findAllSuccessfully(){
        StudentDto studentDto1= new StudentDto(1L,"Student Name 1", "Student Address 1 ", Gender.FEMALE,18);
        StudentDto studentDto2= new StudentDto(2L,"Student Name 2", "Student Address 2", Gender.MALE,22);

        List<StudentDto> studentDtoList = new ArrayList<>();

        studentDtoList.add(studentDto1);
        studentDtoList.add(studentDto2);

        when(studentService.findAll()).thenReturn(studentDtoList);

        ResponseEntity<List<StudentDto>> actual = this.studentController.findAll();

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK ),
                () -> assertEquals(actual.getBody().size(), studentDtoList.size() ),
                () -> assertEquals(actual.getBody(), studentDtoList )
        );
    }

    @Test
    void updateSuccessfully(){
        StudentDto studentDto= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        ResponseEntity<?> actual = this.studentController.update(studentDto);

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void deleteSuccessfully(){
        StudentDto studentDto= new StudentDto(1L,"Student Name", "Student Address", Gender.FEMALE,18);

        ResponseEntity<?> actual = this.studentController.delete(studentDto.getId());

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }
}
