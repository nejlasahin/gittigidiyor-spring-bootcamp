package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.enums.Gender;
import spring.bootcamp.week4.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents a Student inherited from BaseEntity class.
 * A Student can be enrolled in many courses.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student extends BaseEntity {

    // The first and last name of this Student.
    @Column(name = "full_name")
    private String fullName;

    // The address of this Student.
    @Column(name = "address")
    private String address;

    // The gender of this Student.
    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    // The age of this Student.
    @Column(name = "age")
    private int age;

    // The courses of this Student.
    @ManyToMany
    @JoinTable(
            name = "course_students",
            joinColumns = @JoinColumn(name = "course_id"),
            foreignKey = @ForeignKey(name = "fk_course"),
            inverseJoinColumns = @JoinColumn(name = "student_id"),
            inverseForeignKey = @ForeignKey(name = "fk_student")
    )
    private Set<Course> courses = new HashSet<>();
}
