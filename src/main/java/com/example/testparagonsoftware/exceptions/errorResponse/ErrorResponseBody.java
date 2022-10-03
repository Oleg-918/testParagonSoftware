package com.example.testparagonsoftware.exceptions.errorResponse;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponseBody {

    private List<ErrorInfo> errors;

    public ErrorResponseBody() {
        this(new ArrayList<>());
    }

    public ErrorResponseBody(List<ErrorInfo> errors) {
        this.errors = errors;
    }

    public void addError(ErrorInfo errorInfo) {
        errors.add(errorInfo);
    }

    public void addError(String name, String description) {
        addError(new ErrorInfo(name, description));
    }
}
