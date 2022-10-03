package com.example.testparagonsoftware.exceptions.errorResponse;

import lombok.Data;

@Data
public class ErrorInfo {

    private String name;
    private String description;

    public ErrorInfo(String name, String description) {
        this.name = name;
        this.description = description;
    }

}
