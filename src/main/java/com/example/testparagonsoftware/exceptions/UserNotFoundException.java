package com.example.testparagonsoftware.exceptions;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Integer userId) {
        super("Не удалось найти пользователя по id = " + userId);
    }
}
