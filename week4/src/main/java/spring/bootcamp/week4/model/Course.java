package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Course inherited from BaseEntity class.
 *
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course extends BaseEntity {

    // The course name of this Course.
    @Column(name = "course_name")
    private String courseName;

    // The course code of this Course.
    @Column(name = "course_code")
    private String courseCode;

    // The credit score of this Course.
    @Column(name = "credit_score")
    private int creditScore;

    // The students of this Course.
    @ManyToMany(mappedBy = "courses")
    private Set<Student> students = new HashSet<>();

    // The instructor of this Course.
    @ManyToOne
    @JoinColumn(name = "instructor_id", foreignKey = @ForeignKey(name = "fk_instructor"))
    private Instructor instructor;

}
