package spring.bootcamp.week5.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import spring.bootcamp.week5.dto.CourseDto;
import spring.bootcamp.week5.model.Course;
import spring.bootcamp.week5.service.CourseService;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class CourseControllerTest {

    @Mock
    CourseService courseService;

    @InjectMocks
    CourseController courseController;

    @Test
    void saveSuccessfully(){
        CourseDto courseDto= new CourseDto(1L, "Java", "JV121", 4);

        when(courseService.save(courseDto)).thenReturn(courseDto);

        ResponseEntity<CourseDto> actual = this.courseController.save(courseDto);

        assertAll(
                () -> assertNotNull(actual.getBody()),
                () -> assertEquals(courseDto.getCourseCode(), actual.getBody().getCourseCode()),
                () -> assertEquals(courseDto, actual.getBody()),
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void findAllSuccessfully(){
        List<CourseDto> courseDtoList = new ArrayList<>();

        CourseDto courseDto1= new CourseDto(1L, "Java", "JV121", 4);
        CourseDto courseDto2 = new CourseDto(2L, "C++", "CP233", 2);
        courseDtoList.add(courseDto1);
        courseDtoList.add(courseDto2);

        when(courseService.findAll()).thenReturn(courseDtoList);

        ResponseEntity<List<CourseDto>> actual = this.courseController.findAll(courseDtoList);

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK ),
                () -> assertEquals(actual.getBody().size(), courseDtoList.size() ),
                () -> assertEquals(actual.getBody(), courseDtoList )
        );
    }

    @Test
    void updateSuccessfully(){
        CourseDto courseDto= new CourseDto(1L, "Java", "JV121", 4);

        ResponseEntity<?> actual = this.courseController.update(courseDto);

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

    @Test
    void deleteSuccessfully(){
        CourseDto courseDto= new CourseDto(1L, "Java", "JV121", 4);

        ResponseEntity<?> actual = this.courseController.delete(courseDto.getId());

        assertAll(
                () -> assertEquals(actual.getStatusCode(), HttpStatus.OK )
        );
    }

}
