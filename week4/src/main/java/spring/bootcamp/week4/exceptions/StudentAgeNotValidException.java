package spring.bootcamp.week4.exceptions;

public class StudentAgeNotValidException extends RuntimeException{
    public StudentAgeNotValidException(String message) {
        super(message);
    }
}
