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
@RequestMapping("todo")
public class ToDoController {

    private final ToDoServiceMultiThread toDoServiceMultiThread;
    private final ToDoService toDoService;

    public ToDoController(ToDoServiceMultiThread toDoServiceMultiThread, ToDoService toDoService) {
        this.toDoServiceMultiThread = toDoServiceMultiThread;

        this.toDoService = toDoService;
    }

    @GetMapping("/getAll")
    public CompletableFuture<BaseResponse> getAll() {
        return toDoServiceMultiThread.getToDoRepo();
    }

    @PostMapping("/add")
    public CompletableFuture<BaseResponse> add(@RequestBody ToDoRequest toDo) {
        return toDoServiceMultiThread.addToDo(toDo);
    }

    @DeleteMapping("/delete/{id}")
    public CompletableFuture<BaseResponse> delete(@PathVariable Long id) {
        return toDoServiceMultiThread.deleteToDo(id);
    }
    @GetMapping("/getById/{id}")
    public CompletableFuture<BaseResponse> getById(@PathVariable("id") Long id) {
        return toDoServiceMultiThread.getByID(id);
    }
}
//21-18 ms synchr post and delete