package br.com.unifei.projetoclinica.exceptions;

import java.time.Instant;
import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(NotFoundException e) {
        var error = new StandardError(e.getMessage(), Date.from(Instant.now()));

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<StandardError> badRequestException(BadRequestException e) {
        var error = new StandardError(e.getMessage(), Date.from(Instant.now()));

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
