package xyz.dlulalne.restfulwebservices.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDate;

@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler {

    // Add an exception handler
    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleException(UserNotFoundException exc){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.NOT_FOUND.value());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setTimestamp(LocalDate.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    // Add an exception handler
    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleAllException(Exception exc){

        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMessage(exc.getMessage());
        errorDetails.setTimestamp(LocalDate.now());

        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
