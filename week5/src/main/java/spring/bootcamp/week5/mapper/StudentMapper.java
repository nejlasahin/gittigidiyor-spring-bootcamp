package spring.bootcamp.week5.mapper;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Named;
import spring.bootcamp.week5.dto.StudentDto;
import spring.bootcamp.week5.model.Student;

import java.util.List;

@Mapper
public interface StudentMapper {
    Student mapFromStudentDtoToStudent(StudentDto studentDto);

    @Named("mapFromStudentToStudentDto")
    StudentDto mapFromStudentToStudentDto(Student student);

    @IterableMapping(qualifiedByName = "mapFromStudentToStudentDto")
    List<StudentDto> mapFromStudentsToStudentDto(List<Student> students);
}
