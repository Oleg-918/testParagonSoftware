package com.example.testparagonsoftware.model;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public enum UserStatusEnum {
    ONLINE, AWAY, OFFLINE, NONE;
    private String name;
    private LocalDateTime changeTime;

    UserStatusEnum() {
        this.name = this.name();
        this.changeTime = LocalDateTime.now();
    }


}
