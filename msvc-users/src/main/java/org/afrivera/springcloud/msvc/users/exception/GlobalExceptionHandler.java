package org.afrivera.springcloud.msvc.users.exception;

import org.afrivera.springcloud.msvc.users.dto.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorDetail> resourceNotfoundException(ResourceNotFoundException exception, WebRequest request){
        ErrorDetail error = new ErrorDetail(exception.getMessage(), HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error)->{
            String key = ((FieldError)error).getField();
            String value = error.getDefaultMessage();
            errors.put(key, value);
        });
        ErrorDetail error = new ErrorDetail("arguments not valid", HttpStatus.BAD_REQUEST.value(), errors);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
