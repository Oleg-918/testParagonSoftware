package com.example.testparagonsoftware.exceptions;

import org.springframework.validation.BindingResult;

public class FieldValidationException extends RuntimeException {

    private BindingResult result;

    public FieldValidationException(BindingResult result) {
        this.result = result;
    }

    public BindingResult getResult() {
        return result;
    }
}
