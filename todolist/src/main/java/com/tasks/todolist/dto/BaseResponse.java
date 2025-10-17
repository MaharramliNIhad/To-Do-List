package com.tasks.todolist.dto;

import java.time.LocalDateTime;

public class BaseResponse {
    private Object data;
    private String message;
    private LocalDateTime timestamp;

    public Object getData() {
        return data;
    }

    public BaseResponse setData(Object data) {
        this.data = data;
        return this;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public BaseResponse setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public BaseResponse setMessage(String message) {
        this.message = message;
        return this;
    }

    @Override
    public String toString() {
        return "BaseResponse{" +
                "data=" + data +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }//used lombok
}
