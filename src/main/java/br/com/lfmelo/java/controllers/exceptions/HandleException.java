package br.com.lfmelo.java.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
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
}
