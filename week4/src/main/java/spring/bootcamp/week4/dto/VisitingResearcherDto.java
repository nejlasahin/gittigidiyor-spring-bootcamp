package spring.bootcamp.week4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VisitingResearcherDto extends InstructorDto {
    private double hourlySalary;
}
