package spring.bootcamp.week5.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week5.enums.Gender;

import javax.validation.constraints.NotBlank;
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

    public StudentDto(long id, String fullName, String address, Gender gender, int age) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.gender = gender;
        this.age = age;
    }
}
