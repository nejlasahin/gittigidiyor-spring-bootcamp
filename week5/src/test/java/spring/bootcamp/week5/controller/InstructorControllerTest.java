package spring.bootcamp.week5.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.bootcamp.week5.dto.InstructorDto;
import spring.bootcamp.week5.enums.InstructorType;
import spring.bootcamp.week5.service.InstructorService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class InstructorControllerTest {

    @Mock
    InstructorService instructorService;

    @InjectMocks
    InstructorController instructorController;

    @Test
    void saveSuccessfully(){
        InstructorDto instructorDto= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        when(instructorService.save(instructorDto)).thenReturn(instructorDto);

        ResponseEntity<InstructorDto> actual = this.instructorController.save(instructorDto);

        assertAll(
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(instructorDto.getId(), actual.getBody().getId()),
                () -> assertEquals(instructorDto, actual.getBody()),
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void findAllSuccessfully(){
        InstructorDto instructorDto1= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name 1","Instructor Address 1","5352347869");
        InstructorDto instructorDto2= new InstructorDto(2L, InstructorType.VISITING_RESEARCHER, "Instructor Name 2","Instructor Address 2","5444432567");

        List<InstructorDto> instructorDtoList = new ArrayList<>();

        instructorDtoList.add(instructorDto1);
        instructorDtoList.add(instructorDto2);

        when(instructorService.findAll()).thenReturn(instructorDtoList);

        ResponseEntity<List<InstructorDto>> actual = this.instructorController.findAll();

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK ),
                () -> assertEquals(actual.getBody().size(), instructorDtoList.size() ),
                () -> assertEquals(actual.getBody(), instructorDtoList)
        );
    }

    @Test
    void updateSuccessfully(){
        InstructorDto instructorDto= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        ResponseEntity<?> actual = this.instructorController.update(instructorDto);

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void deleteSuccessfully(){
        InstructorDto instructorDto= new InstructorDto(1L, InstructorType.PERMANENT_INSTRUCTOR, "Instructor Name","Instructor Address","5352347869");

        ResponseEntity<?> actual = this.instructorController.delete(instructorDto.getId());

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }
}
