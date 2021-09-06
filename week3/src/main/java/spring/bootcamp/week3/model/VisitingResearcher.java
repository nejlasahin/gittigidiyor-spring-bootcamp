package spring.bootcamp.week3.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visiting_researchers")
@PrimaryKeyJoinColumn(name="id")
@SuperBuilder
public class VisitingResearcher extends Instructor{

    @Column(name = "hourly_salary")
    private double hourlySalary;
}
