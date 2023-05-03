package br.com.lfmelo.java.controllers.exceptions;

import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StandardException {

    private String message;
    private LocalDateTime date;
    private String path;
    private String error;

    public StandardException() {}

    public StandardException(String error, String message, LocalDateTime date, String path) {
        this.message = message;
        this.date = date;
        this.path = path;
        this.error = error;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setError(String error) {
        this.error = error;
    }
}
