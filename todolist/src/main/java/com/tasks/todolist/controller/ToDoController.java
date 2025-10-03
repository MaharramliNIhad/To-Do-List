package com.tasks.todolist.controller;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.service.ToDoService;
import com.tasks.todolist.service.ToDoServiceMultiThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("//v1/todo")
public class ToDoController {

    private final ToDoServiceMultiThread toDoServiceMultiThread;
    private final ToDoService toDoService;

    public ToDoController(ToDoServiceMultiThread toDoServiceMultiThread, ToDoService toDoService) {
        this.toDoServiceMultiThread = toDoServiceMultiThread;

        this.toDoService = toDoService;
    }

    @GetMapping
    public CompletableFuture<BaseResponse> getAll() {
        return toDoServiceMultiThread.getToDoRepo();
    }

    @PostMapping
    public CompletableFuture<BaseResponse> add(@RequestBody ToDoRequest toDo) {
        return toDoServiceMultiThread.addToDo(toDo);
    }

    @DeleteMapping("/{id}")
    public CompletableFuture<BaseResponse> delete(@PathVariable Long id) {
        return toDoServiceMultiThread.deleteToDo(id);
    }
    @GetMapping("/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        return toDoService.getByID(id);
    }
}
//21-18 ms synchr post and delete