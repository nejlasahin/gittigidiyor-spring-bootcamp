package spring.bootcamp.week4.model;

/**
 * @author Nejla Sahin
 * @version 1.0
 */

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.enums.InstructorType;
import spring.bootcamp.week4.model.abstracts.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Represents an Instructor inherited from BaseEntity class.
 * There are 2 types of Instructors; Visiting Researcher or Permanent Instructor.
 * A course could be instructed by only one Instructor.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PERMANENT_INSTRUCTOR"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VISITING_RESEARCHER")
})
@Inheritance(strategy = InheritanceType.JOINED)
@Entity
@Table(name = "instructors")
public class Instructor extends BaseEntity {

    // The subclass type of this Instructor. Type must be PERMANENT_INSTRUCTOR or VISITING_RESEARCHER
    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private InstructorType type;

    // The first and last name of this Instructor.
    @Column(name = "full_name")
    private String fullName;

    // The address of this Instructor.
    @Column(name = "address")
    private String address;

    // The phone number of this Instructor. Phone number must be 10 characters long.
    @Column(name = "phone_number")
    private String phoneNumber;

    // The course of this Instructor.
    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses = new HashSet<>();
}
