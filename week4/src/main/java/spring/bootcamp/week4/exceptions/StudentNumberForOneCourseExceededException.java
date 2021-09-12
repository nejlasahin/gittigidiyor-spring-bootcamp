package spring.bootcamp.week4.exceptions;

public class StudentNumberForOneCourseExceededException extends RuntimeException{
    public StudentNumberForOneCourseExceededException(String message) {
        super(message);
    }
}
