package com.tasks.todolist.controller;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.service.ToDoService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/todo")
public class ToDoController {

    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }


    @GetMapping("/{id}")
    public ToDoResponse getById(@PathVariable Long id) {
        return toDoService.getByID(id);
    }
    @PostMapping
    public Long save(@RequestBody ToDoRequest toDoRequest){
       return toDoService.addToDo(toDoRequest);
    }
}
