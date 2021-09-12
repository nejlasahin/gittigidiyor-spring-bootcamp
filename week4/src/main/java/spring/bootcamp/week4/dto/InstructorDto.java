package spring.bootcamp.week4.dto;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.bootcamp.week4.enums.InstructorType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.EXISTING_PROPERTY, property = "type", visible = true)
@JsonSubTypes({
        @JsonSubTypes.Type(value = PermanentInstructorDto.class, name = "PERMANENT_INSTRUCTOR"),
        @JsonSubTypes.Type(value = VisitingResearcherDto.class, name = "VISITING_RESEARCHER")
})
public class InstructorDto {

    private long id;

    private InstructorType type;

    @NotBlank(message = "Name is mandatory")
    private String fullName;

    @NotBlank(message = "Address is mandatory")
    private String address;

    @NotBlank(message = "Phone Number is mandatory")
    @Pattern(regexp="(^$|[0-9]{10})", message = "Control")
    private String phoneNumber;
}
