package com.app.smoothie.adapter.primary.rest;

import com.app.smoothie.adapter.primary.rest.json.GeneralError;
import com.app.smoothie.core.sharedkernel.exception.SmoothieNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ApplicationExceptionHandler {

    @ExceptionHandler(SmoothieNotFoundException.class)
    public ResponseEntity<GeneralError> handleSmoothieNotFound(SmoothieNotFoundException e) {
        log.warn("handle exception: code: {}, msg: {}", e.getCode(), e.getMessage(), e);
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
            .body(new GeneralError(e.getCode(), e.getMessage()));
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<GeneralError> handle(BindException e) {
        log.warn("handle bind exception", e);
        final GeneralError generalError =
            new GeneralError("validation_error", e.getMessage());
        return ResponseEntity.badRequest().body(generalError);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<GeneralError> handle(RuntimeException e) {
        log.warn("handle runtime exception", e);
        final GeneralError generalError =
            new GeneralError("internal_error", "internal exception occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(generalError);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<GeneralError> handle(Exception e) {
        log.warn("handle exception", e);
        final GeneralError generalError =
            new GeneralError("internal_error", "internal exception occurred");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(generalError);
    }
}
