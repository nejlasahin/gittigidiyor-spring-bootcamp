package spring.bootcamp.week3.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import spring.bootcamp.week3.enums.Gender;
import spring.bootcamp.week3.enums.InstructorType;
import spring.bootcamp.week3.model.*;
import spring.bootcamp.week3.repository.CourseRepository;
import spring.bootcamp.week3.repository.InstructorRepository;
import spring.bootcamp.week3.repository.StudentRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class InitializerRunner implements CommandLineRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Override
    public void run(String... args) throws Exception {

    instructorRepository.deleteAll();
    studentRepository.deleteAll();
    courseRepository.deleteAll();

    Instructor instructor1 = PermanentInstructor.builder().type(InstructorType.PERMANENT_INSTRUCTOR).fullName("Dulcie").address("46646 Bonner Street").phoneNumber("701-118-3088").fixedSalary(1111).build();
    Instructor instructor2 = PermanentInstructor.builder().type(InstructorType.PERMANENT_INSTRUCTOR).fullName("Jan").address("9 Ilene Junction").phoneNumber("387-125-0540").fixedSalary(2222).build();
    Instructor instructor3 = VisitingResearcher.builder().type(InstructorType.VISITING_RESEARCHER).fullName("Serganent").address("77650 Division Pass").phoneNumber("417-288-5603").hourlySalary(3333).build();

    Course course1 = Course.builder().courseName("Java").courseCode("J101").creditScore(4).instructor(instructor1).build();
    Course course2 = Course.builder().courseName("C#").courseCode("C101").creditScore(3).instructor(instructor2).build();
    Course course3 = Course.builder().courseName("Php").courseCode("P101").creditScore(2).instructor(instructor3).build();

    Set<Course> courseList = new HashSet<>();
    courseList.add(course1);
    courseList.add(course2);
    courseList.add(course3);

    Student student1 =Student.builder().fullName("Brant").birthDate(LocalDate.of(2000, 6, 25)).address("24468 Steensland Hill").gender(Gender.MALE).courses(courseList).build();
    Student student2=Student.builder().fullName("Margit").birthDate(LocalDate.of(1990, 3, 13)).address("87 Hermina Pass").gender(Gender.MALE).courses(courseList).build();
    Student student3=Student.builder().fullName("Filmer").birthDate(LocalDate.of(1995, 11, 2)).address("251 6th Terrace").gender(Gender.FEMALE).courses(courseList).build();

    instructorRepository.save(instructor1);
    instructorRepository.save(instructor2);
    instructorRepository.save(instructor3);

    courseRepository.save(course1);
    courseRepository.save(course2);
    courseRepository.save(course3);

    studentRepository.save(student1);
    studentRepository.save(student2);
    studentRepository.save(student3);


    }

}
