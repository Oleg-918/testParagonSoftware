package com.example.testparagonsoftware.controller;

import com.example.testparagonsoftware.exceptions.ErrorResponse.ErrorResponseBody;
import com.example.testparagonsoftware.exceptions.FieldValidationException;
import com.example.testparagonsoftware.exceptions.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
        return getResponseEntity(HttpStatus.NOT_FOUND, ex);
    }

    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException ex) {
        return getResponseEntity(HttpStatus.BAD_REQUEST, ex);
    }

    @ExceptionHandler(value = {FieldValidationException.class})
    public ResponseEntity<Object> handleFieldValidationException(FieldValidationException ex) {
        ErrorResponseBody errorResponseBody = getErrorValidation(ex.getResult());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponseBody);
    }

    @ExceptionHandler(value = {RuntimeException.class})
    public ResponseEntity<Object> handleServerError(RuntimeException ex) {
        return getResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, ex);
    }

    private ResponseEntity<Object> getResponseEntity(HttpStatus httpStatus, RuntimeException ex) {
        return ResponseEntity.status(httpStatus).body(getErrorResponseBody(ex));
    }

    private ErrorResponseBody getErrorValidation(BindingResult result) {
        ErrorResponseBody errorResponseBody = new ErrorResponseBody();
        result.getFieldErrors()
                .forEach(fieldError -> errorResponseBody.addError(FieldValidationException.class.getSimpleName(), fieldError.getField() + " " + fieldError.getDefaultMessage()));
        return errorResponseBody;
    }

    private ErrorResponseBody getErrorResponseBody(Exception ex) {
        ErrorResponseBody errorResponseBody = new ErrorResponseBody();
        errorResponseBody.addError(ex.getClass().getSimpleName(), ex.getMessage());
        return errorResponseBody;
    }
}
