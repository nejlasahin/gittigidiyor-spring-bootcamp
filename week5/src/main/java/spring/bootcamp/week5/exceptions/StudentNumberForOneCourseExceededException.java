package spring.bootcamp.week5.exceptions;

public class StudentNumberForOneCourseExceededException extends RuntimeException{
    public StudentNumberForOneCourseExceededException(String message) {
        super(message);
    }
}
