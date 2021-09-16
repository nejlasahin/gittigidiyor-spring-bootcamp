package spring.bootcamp.week5.exceptions;

public class InstructorIsAlreadyExistException extends RuntimeException{
    public InstructorIsAlreadyExistException(String message) {
        super(message);
    }
}
