package spring.bootcamp.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PermanentInstructorDto extends InstructorDto {
    private double fixedSalary;
}
