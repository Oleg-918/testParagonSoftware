package com.example.testparagonsoftware.model;

import java.time.Duration;
import java.time.LocalDateTime;

public enum UserStatusEnum {
    ONLINE(1), AWAY(30), OFFLINE(60), NONE(0);

    private String name;
    private Duration duration;
    private LocalDateTime changeTime;

    UserStatusEnum(long duration) {
        this.name = this.name().toLowerCase();
        this.duration = Duration.ofMinutes(duration);
        this.changeTime = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDurationSeconds() {
        return duration.getSeconds();
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }
    public LocalDateTime getChangeTime() {
        return changeTime;
    }

}
