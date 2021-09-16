package spring.bootcamp.week5.exceptions;

public class CourseIsAlreadyException extends RuntimeException{
    public CourseIsAlreadyException(String message) {
        super(message);
    }
}
