package spring.bootcamp.week4.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import spring.bootcamp.week4.dto.InstructorDto;
import spring.bootcamp.week4.dto.PermanentInstructorDto;
import spring.bootcamp.week4.dto.VisitingResearcherDto;
import spring.bootcamp.week4.model.Instructor;
import spring.bootcamp.week4.model.PermanentInstructor;
import spring.bootcamp.week4.model.VisitingResearcher;

import java.util.List;

@Mapper
public interface InstructorMapper {

    Instructor mapFromInstructorDtoToInstructor(InstructorDto instructorDto);
    PermanentInstructor mapFromPermanentInstructorDtoToPermanentInstructor(PermanentInstructorDto permanentInstructorDto);
    VisitingResearcher mapFromVisitingResearcherDtoToVisitingResearcher(VisitingResearcherDto visitingResearcherDTO);

    default Instructor instructorDtoToInstructor(InstructorDto instructorDto) {
        if(instructorDto instanceof PermanentInstructorDto) {
            return mapFromPermanentInstructorDtoToPermanentInstructor((PermanentInstructorDto) instructorDto);
        }else if(instructorDto instanceof VisitingResearcherDto) {
            return mapFromVisitingResearcherDtoToVisitingResearcher((VisitingResearcherDto) instructorDto);
        }
            return mapFromInstructorDtoToInstructor(instructorDto);
    }


    InstructorDto mapFromInstructorToInstructorDto(Instructor instructor);
    PermanentInstructorDto mapFromPermanentInstructorToPermanentInstructorDto(PermanentInstructor permanentInstructor);
    VisitingResearcherDto mapFromVisitingResearcherToVisitingResearcherDto(VisitingResearcher visitingResearcher);

    @Named("instructorToInstructorDto")
    default InstructorDto instructorToInstructorDto(Instructor instructor) {
        if(instructor instanceof PermanentInstructor) {
            return mapFromPermanentInstructorToPermanentInstructorDto((PermanentInstructor) instructor);
        }else if(instructor instanceof VisitingResearcher) {
            return mapFromVisitingResearcherToVisitingResearcherDto((VisitingResearcher) instructor);
        }
            return mapFromInstructorToInstructorDto(instructor);
    }

    @IterableMapping(qualifiedByName = "instructorToInstructorDto")
    List<InstructorDto> mapFromInstructorsToInstructorDto(List<Instructor> instructors);
}
