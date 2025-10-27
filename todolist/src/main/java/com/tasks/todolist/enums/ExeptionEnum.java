package com.tasks.todolist.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
@Getter
@AllArgsConstructor
public enum ExeptionEnum {
    TO_DO_LIST_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "ToDo Not Found"),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "User Not Found");

    int code;
    String msg;
}
