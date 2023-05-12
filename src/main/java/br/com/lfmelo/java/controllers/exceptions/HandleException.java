package br.com.lfmelo.java.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class HandleException {

    @ExceptionHandler(FileException.class)
    public ResponseEntity<StandardException> handleException(FileException exception, HttpServletRequest request) {

        StandardException error = new StandardException();
        error.setError(exception.getMessage());
        error.setMessage("Not Found Exception");
        error.setDate(LocalDateTime.now());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }


    @ExceptionHandler(IOException.class)
    public ResponseEntity<StandardException> handleException(IOException exception, HttpServletRequest request) {

        StandardException error = new StandardException();
        error.setError(exception.getMessage());
        error.setMessage("Not Found Exception");
        error.setDate(LocalDateTime.now());
        error.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
