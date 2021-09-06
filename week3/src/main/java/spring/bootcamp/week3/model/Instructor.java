package spring.bootcamp.week3.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import spring.bootcamp.week3.enums.InstructorType;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructor.class, name = "PERMANENT_INSTRUCTOR"),
        @JsonSubTypes.Type(value = VisitingResearcher.class, name = "VISITING_RESEARCHER")
})
@Inheritance(strategy = InheritanceType .JOINED)
@Entity
@Table(name = "instructors")
@SuperBuilder
public class Instructor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private InstructorType type;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonIgnore
    @OneToMany(mappedBy = "instructor")
    private Set<Course> courses = new HashSet<>();
}
