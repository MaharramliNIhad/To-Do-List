package com.tasks.todolist.controller;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.service.ToDoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("//v1/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        return toDoService.getByID(id);
    }
}
