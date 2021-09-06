package spring.bootcamp.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week3.model.Student;
import spring.bootcamp.week3.model.StudentGroup;
import spring.bootcamp.week3.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public ResponseEntity<Student> save(@RequestBody Student student){
        Student result = studentService.save(student);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Student student){
        studentService.update(student);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteByFullName/{fullName}")
    public ResponseEntity<?> deleteByFullName(@PathVariable String fullName){
        studentService.deleteByFullName(fullName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Student> findById(@PathVariable long id){
        Optional<Student> student = studentService.findById(id);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @GetMapping("/findByFullName/{fullName}")
    public ResponseEntity<Student> findByFullName(@PathVariable String fullName){
        Optional<Student> student = studentService.findByFullName(fullName);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Student>> findAll(){
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/studentGroupByGender")
    public ResponseEntity<List<StudentGroup>> studentGroupByGender(){
        List<StudentGroup> studentGroups = studentService.studentGroupByGender();
        return new ResponseEntity<>(studentGroups, HttpStatus.OK);
    }
}
