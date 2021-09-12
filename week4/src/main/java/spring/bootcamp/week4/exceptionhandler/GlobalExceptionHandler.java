package spring.bootcamp.week4.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.bootcamp.week4.exceptions.*;
import spring.bootcamp.week4.model.AppError;
import spring.bootcamp.week4.repository.AppErrorRepository;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private final AppErrorRepository appErrorRepository;

    public GlobalExceptionHandler(AppErrorRepository appErrorRepository) {
        this.appErrorRepository = appErrorRepository;
    }

    private AppError prepareErrorResponse(HttpStatus httpStatus, String message){
        AppError appError = new AppError();
        appError.setMessage(message);
        appError.setStatus(httpStatus.value());
        appError.setTimestamp(System.currentTimeMillis());
        return appError;
    }

    @ExceptionHandler(CourseIsAlreadyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppError> handleException(CourseIsAlreadyException exception){
        AppError appError = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        appErrorRepository.save(appError);
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(InstructorIsAlreadyExistException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppError> handleException(InstructorIsAlreadyExistException exception){
        AppError appError = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        appErrorRepository.save(appError);
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<AppError> handleException(ResourceNotFoundException exception){
        AppError appError = prepareErrorResponse(HttpStatus.NOT_FOUND, exception.getMessage());
        appErrorRepository.save(appError);
        return new ResponseEntity<>(appError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(StudentAgeNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppError> handleException(StudentAgeNotValidException exception){
        AppError appError = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        appErrorRepository.save(appError);
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(StudentNumberForOneCourseExceededException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<AppError> handleException(StudentNumberForOneCourseExceededException exception){
        AppError appError = prepareErrorResponse(HttpStatus.BAD_REQUEST, exception.getMessage());
        appErrorRepository.save(appError);
        return new ResponseEntity<>(appError, HttpStatus.BAD_REQUEST);
    }


}
