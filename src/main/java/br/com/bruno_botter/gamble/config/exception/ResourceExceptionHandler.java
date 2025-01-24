package br.com.bruno_botter.gamble.config.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandartError> dataIntegrityViolation(DataIntegrityException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Data integrity violation", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(InsuficientBalanceException.class)
    public ResponseEntity<StandartError> InsuficientBalance(InsuficientBalanceException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandartError> UserNotFound(UserNotFoundException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
    @ExceptionHandler(GambleNotFoundException.class)
    public ResponseEntity<StandartError> GambleNotFound(GambleNotFoundException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Error", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandartError> validation(MethodArgumentNotValidException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.UNPROCESSABLE_ENTITY.value(),
                "Validation Error", e.getMessage(), request.getRequestURI());
        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(err);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StandartError> validation(MethodArgumentTypeMismatchException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Validation Error", e.getMessage(), request.getRequestURI());

            err.addError(e.getName(), e.getMessage());


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandartError> noSuchElementException(NoSuchElementException e, HttpServletRequest request) {

        ValidationError err = new ValidationError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(),
                "Miss value", e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }
}
