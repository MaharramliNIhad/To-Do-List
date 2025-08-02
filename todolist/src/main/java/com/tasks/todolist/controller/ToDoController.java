package com.tasks.todolist.controller;

import com.tasks.todolist.entity.ToDo;
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
    @GetMapping
    public List<ToDo> getAll(){
        return toDoService.getToDoRepo();
    }
@PostMapping("add")
    public String add(ToDo toDo){
        return toDoService.addToDo(toDo);
}
@DeleteMapping("delete/{id}")
    public String delete(@PathVariable Long id){
        return toDoService.deleteToDo(id);
}
}
