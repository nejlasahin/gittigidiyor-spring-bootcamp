package spring.bootcamp.week4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.bootcamp.week4.dto.InstructorDto;
import spring.bootcamp.week4.service.InstructorService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {
    private final InstructorService instructorService;

    @Autowired
    public InstructorController(InstructorService instructorService) {
        this.instructorService = instructorService;
    }

    @PostMapping
    public ResponseEntity<InstructorDto> saveInstructor(@Valid @RequestBody InstructorDto instructorDto){
        InstructorDto result = instructorService.save(instructorDto);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@Valid @RequestBody InstructorDto instructorDto){
        instructorService.update(instructorDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable long id){
        instructorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<InstructorDto>> findAll(){
        List<InstructorDto> instructors = instructorService.findAll();
        return new ResponseEntity<>(instructors, HttpStatus.OK);
    }
}
