package spring.bootcamp.week4.exceptions;

public class InstructorIsAlreadyExistException extends RuntimeException{
    public InstructorIsAlreadyExistException(String message) {
        super(message);
    }
}
