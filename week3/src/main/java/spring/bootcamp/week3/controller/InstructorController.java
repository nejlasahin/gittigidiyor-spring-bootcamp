package spring.bootcamp.week3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week3.model.Instructor;
import spring.bootcamp.week3.model.InstructorOrder;
import spring.bootcamp.week3.service.InstructorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping("/save")
    public ResponseEntity<Instructor> save(@RequestBody Instructor instructor){
        Instructor result = instructorService.save(instructor);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody Instructor instructor){
        instructorService.update(instructor);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> deleteById(@PathVariable long id){
        instructorService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deleteByFullName/{fullName}")
    public ResponseEntity<?> deleteByFullName(@PathVariable String fullName){
        instructorService.deleteByFullName(fullName);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Instructor> findById(@PathVariable long id){
        Optional<Instructor> instructor = instructorService.findById(id);
        return new ResponseEntity<>(instructor.get(), HttpStatus.OK);
    }

    @GetMapping("/findByFullName/{fullName}")
    public ResponseEntity<Instructor> findByFullName(@PathVariable String fullName){
        Optional<Instructor> instructor = instructorService.findByFullName(fullName);
        return new ResponseEntity<>(instructor.get(), HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<Instructor>> findAll(){
        List<Instructor> instructors = instructorService.findAll();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

    @GetMapping("/orderBySalaryTop3")
    public ResponseEntity<List<InstructorOrder>> orderBySalaryTop3(){
        List<InstructorOrder> instructors = instructorService.orderBySalaryTop3();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }

}
