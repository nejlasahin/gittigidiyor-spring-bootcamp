package spring.bootcamp.week4.exceptions;

public class CourseIsAlreadyException extends RuntimeException{
    public CourseIsAlreadyException(String message) {
        super(message);
    }
}
