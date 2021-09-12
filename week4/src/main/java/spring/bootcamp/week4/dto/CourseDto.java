package spring.bootcamp.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseDto {
    private long id;

    @NotBlank(message = "Course Name is mandatory")
    private String courseName;

    @NotBlank(message = "Course Code is mandatory")
    private String courseCode;

    @Range(min = 1,max= 10, message = "Credit Score should be a minimum of 1 and a maximum of 10.")
    private int creditScore;

    private Set<StudentDto> students = new HashSet<>();

    private InstructorDto instructor;


}
