package spring.bootcamp.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.enums.Gender;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private long id;

    @NotBlank(message = "Name is mandatory")
    private String fullName;

    @NotBlank(message = "Address is mandatory")
    private String address;

    private Gender gender;

    private int age;

    private Set<CourseDto> courses = new HashSet<>();
}
