package spring.bootcamp.week4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week4.dto.CourseDto;
import spring.bootcamp.week4.service.CourseService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    /**
     *
     * @param courseDto
     * @return
     */
    @PostMapping
    public ResponseEntity<CourseDto> save(@Valid @RequestBody CourseDto courseDto){
        CourseDto result = courseService.save(courseDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody CourseDto courseDto){
        courseService.update(courseDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        courseService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CourseDto>> findAll(){
        List<CourseDto> courses = courseService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
