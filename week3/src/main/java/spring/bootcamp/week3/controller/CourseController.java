package spring.bootcamp.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week3.model.Course;
import spring.bootcamp.week3.service.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    @Autowired
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping("/save")
    public ResponseEntity<Course> save(@RequestBody Course course){
        Course result = courseService.save(course);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Course course){
        courseService.update(course);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        courseService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteByCourseName/{courseName}")
    public ResponseEntity<?> deleteByCourseName(@PathVariable String courseName){
        courseService.deleteByCourseName(courseName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Course> findById(@PathVariable long id){
        Optional<Course> courses = courseService.findById(id);
        return new ResponseEntity<>(courses.get(), HttpStatus.OK);
    }

    @GetMapping("/findByCourseName/{courseName}")
    public ResponseEntity<Course> findByCourseName(@PathVariable String courseName){
        Optional<Course> courses = courseService.findByCourseName(courseName);
        return new ResponseEntity<>(courses.get(), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Course>> findAll(){
        List<Course> courses = courseService.findAll();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
}
