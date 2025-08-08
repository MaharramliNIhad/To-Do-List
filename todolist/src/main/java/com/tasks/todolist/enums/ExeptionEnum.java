package com.tasks.todolist.enums;

import org.springframework.http.HttpStatus;

public enum ExeptionEnum {
    ToDoListNotFound(HttpStatus.NOT_FOUND.value(), "Not Found");
    int code;
    String msg;
    private ExeptionEnum(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public int getCode() {
        return code;
    }
    public String getMsg() {
        return msg;
    }
}
