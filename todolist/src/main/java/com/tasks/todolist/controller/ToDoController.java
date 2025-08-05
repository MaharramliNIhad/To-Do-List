package com.tasks.todolist.controller;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.service.ToDoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("todo")
public class ToDoController {
    private final ToDoService toDoService;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @GetMapping("/getAll")
    public BaseResponse getAll() {
        return toDoService.getToDoRepo();
    }

    @PostMapping("/add")
    public BaseResponse add(@RequestBody ToDoRequest toDo) {
        return toDoService.addToDo(toDo);
    }

    @DeleteMapping("/delete/{id}")
    public BaseResponse delete(@PathVariable Long id) {
        return toDoService.deleteToDo(id);
    }
}
