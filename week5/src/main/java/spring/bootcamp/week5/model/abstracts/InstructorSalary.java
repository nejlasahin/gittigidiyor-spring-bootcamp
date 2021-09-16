package spring.bootcamp.week5.model.abstracts;

import spring.bootcamp.week5.enums.InstructorType;

public interface InstructorSalary {
    InstructorType getType();
    double getSalary();
}
