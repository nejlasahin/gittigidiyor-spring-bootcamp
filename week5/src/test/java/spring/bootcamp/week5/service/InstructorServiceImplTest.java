package spring.bootcamp.week5.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import spring.bootcamp.week5.dto.InstructorDto;
import spring.bootcamp.week5.dto.StudentDto;
import spring.bootcamp.week5.enums.Gender;
import spring.bootcamp.week5.enums.InstructorType;
import spring.bootcamp.week5.mapper.InstructorMapper;
import spring.bootcamp.week5.model.Instructor;
import spring.bootcamp.week5.model.Student;
import spring.bootcamp.week5.repository.InstructorRepository;
import spring.bootcamp.week5.service.impl.InstructorServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
public class InstructorServiceImplTest {

    @Mock
    InstructorMapper instructorMapper;

    @Mock
    InstructorRepository instructorRepository;

    @InjectMocks
    InstructorServiceImpl instructorServiceImpl;

    @Test
    public void saveSuccessfully(){
        Instructor instructor = new Instructor(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");
        InstructorDto instructorDto= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        when(instructorMapper.instructorDtoToInstructor(instructorDto)).thenReturn(instructor);
        when(instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber())).thenReturn(Boolean.FALSE);
        when(instructorRepository.save(instructor)).thenReturn(instructor);
        when(instructorMapper.instructorToInstructorDto(instructor)).thenReturn(instructorDto);

        InstructorDto actual = this.instructorServiceImpl.save(instructorDto);

        assertAll(
                () -> assertNotNull(actual),
                () -> assertEquals(instructorDto, actual),
                () -> assertEquals(instructorDto.getId(),actual.getId())
        );

    }

    @Test
    public void findAllSuccessfully(){
        List<InstructorDto> instructorDtoList = new ArrayList<>();
        List<Instructor> instructorList = new ArrayList<>();

        Instructor instructor1 = new Instructor(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name 1","Instructor Address 1","5352347869");
        Instructor instructor2 = new Instructor(2L, InstructorType.VISITING_RESEARCHER, "Instructor Name 2","Instructor Address 2","5882347869");

        instructorList.add(instructor1);
        instructorList.add(instructor2);

        InstructorDto instructorDto1= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name 1","Instructor Address 1","5352347869");
        InstructorDto instructorDto2= new InstructorDto(2L, InstructorType.VISITING_RESEARCHER, "Instructor Name 2","Instructor Address 2","5882347869");

        instructorDtoList.add(instructorDto1);
        instructorDtoList.add(instructorDto2);

        when(instructorRepository.findAll()).thenReturn(instructorList);
        when(instructorMapper.mapFromInstructorsToInstructorDto(instructorList)).thenReturn(instructorDtoList);

        List<InstructorDto> instructorDtos = this.instructorServiceImpl.findAll();

        assertAll(
                () -> assertNotNull(instructorDtoList),
                () -> assertEquals(instructorDtos, instructorDtoList),
                () -> assertEquals(instructorDtos.size(), instructorDtoList.size())
        );

    }

    @Test
    public void updateSuccessfully(){
        Instructor instructor = new Instructor(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");
        InstructorDto instructorDto= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        when(instructorMapper.instructorDtoToInstructor(instructorDto)).thenReturn(instructor);
        when(instructorRepository.existsById(instructor.getId())).thenReturn(Boolean.TRUE);
        when(instructorRepository.existsByPhoneNumber(instructor.getPhoneNumber())).thenReturn(Boolean.FALSE);
        when(instructorRepository.save(instructor)).thenReturn(instructor);

        assertDoesNotThrow(
                () -> this.instructorServiceImpl.update(instructorDto)
        );


    }

    @Test
    public void deleteSuccessfully(){
        Instructor instructor = new Instructor(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        when(instructorRepository.existsById(instructor.getId())).thenReturn(Boolean.TRUE);

        assertDoesNotThrow(
                () -> this.instructorServiceImpl.delete(instructor.getId())
        );
    }
}
