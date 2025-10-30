package com.tasks.todolist.exeption;

import com.tasks.todolist.enums.ExeptionEnum;
import com.tasks.todolist.dto.ExeptionResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExeptionHandler {

    @ExceptionHandler(ToDoListNotFoundExeption.class) //404, 400, 401, 403, 500 - handle eden caseleri cover et
    public ExeptionResponse notFound(ToDoListNotFoundExeption exeption) {
        return new ExeptionResponse()
                .setCode(ExeptionEnum.TO_DO_LIST_NOT_FOUND.getCode())
                .setMessage(exeption.getMessage())
                .setTimestamp(LocalDateTime.now());
    }
    @ExceptionHandler(UserNotFoundExeption.class)
    public ExeptionResponse UserNotFound(UserNotFoundExeption exeption) {
        return new ExeptionResponse()
                .setCode(ExeptionEnum.USER_NOT_FOUND.getCode())
                .setMessage(exeption.getMessage())
                .setTimestamp(LocalDateTime.now());
    }
}
