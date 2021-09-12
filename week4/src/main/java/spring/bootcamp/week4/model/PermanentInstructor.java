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
 * Represents a Permanent Instructor inherited from Instructor class.
 *
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "permanent_instructors")
@PrimaryKeyJoinColumn(name="id")
public class PermanentInstructor extends Instructor{

    // The fixed salary of this Permanent Instructor.
    @Column(name = "fixed_salary")
    private double fixedSalary;
}
