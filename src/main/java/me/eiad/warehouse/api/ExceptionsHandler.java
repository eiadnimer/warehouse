package me.eiad.warehouse.api;

import lombok.extern.slf4j.Slf4j;
import me.eiad.warehouse.exceptions.*;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;

@ControllerAdvice
@Slf4j
public class ExceptionsHandler {

    @ExceptionHandler(AmountIsMinus.class)
    public ResponseEntity<ErrorResponse> handle(AmountIsMinus ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Amount must be positive"));
    }

    @ExceptionHandler(FieldMustNotBeEmpty.class)
    public ResponseEntity<ErrorResponse> handle(FieldMustNotBeEmpty ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse(ex.getMessage()));
    }

    @ExceptionHandler(IdMustBePositive.class)
    public ResponseEntity<ErrorResponse> handle(IdMustBePositive ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Unique id must be positive"));
    }

    @ExceptionHandler(MustBeUpperCase.class)
    public ResponseEntity<ErrorResponse> handle(MustBeUpperCase ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Currency must be upper case"));
    }

    @ExceptionHandler(NoDealInFuture.class)
    public ResponseEntity<ErrorResponse> handle(NoDealInFuture ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Deal timestamp must not be in future"));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ErrorResponse> handle(DataIntegrityViolationException ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Deal with unique id already exist"));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handle(Exception ex) {
        return ResponseEntity.badRequest()
                .body(new ErrorResponse("Something went wrong, contact your admin"));
    }
}
