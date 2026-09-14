package com.mini.StudentManagement.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleStudentNotFound(StudentNotFoundException ex){
        ErrorResponse error = new ErrorResponse(
                404,
                LocalDateTime.now(),
                ex.getMessage(),
                null
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public  ResponseEntity<ErrorResponse> handleValidation(ConstraintViolationException ex){
        Map<String,String> violations = new HashMap<>();
        for(ConstraintViolation<?> error:ex.getConstraintViolations()){
           violations.put(error.getPropertyPath().toString(),error.getMessage());
        }
        ErrorResponse error = new ErrorResponse(
                400,
                LocalDateTime.now(),
                "Validation Failed",
                violations
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleInvalidQuery(MethodArgumentTypeMismatchException ex){
        ErrorResponse error = new ErrorResponse(
                400,
                LocalDateTime.now(),
                ex.getValue()+" cannot be converted into "+ex.getRequiredType().getSimpleName(),
                null
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }
}
