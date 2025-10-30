package com.tasks.todolist.dto;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExeptionResponse {
    private int code;
    private String message;
    private LocalDateTime timestamp;

    public int getCode() {
        return code;
    }

    public ExeptionResponse setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ExeptionResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public ExeptionResponse setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }
}//used lombok
