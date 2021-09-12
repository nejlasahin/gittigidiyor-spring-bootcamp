package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Represents a Visiting Researcher inherited from the Instructor class.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "visiting_researchers")
@PrimaryKeyJoinColumn(name="id")
public class VisitingResearcher extends Instructor{

    // The hourly salary of this Visiting Researcher.
    @Column(name = "hourly_salary")
    private double hourlySalary;
}
