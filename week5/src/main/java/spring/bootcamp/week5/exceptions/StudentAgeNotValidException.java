package spring.bootcamp.week5.exceptions;

public class StudentAgeNotValidException extends RuntimeException{
    public StudentAgeNotValidException(String message) {
        super(message);
    }
}
