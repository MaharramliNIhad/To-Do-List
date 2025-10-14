package com.tasks.todolist.controller;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.service.ToDoService;
import com.tasks.todolist.service.ToDoServiceMultiThread;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
