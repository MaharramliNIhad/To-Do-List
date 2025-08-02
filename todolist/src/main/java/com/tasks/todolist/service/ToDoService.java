package com.tasks.todolist.service;

import com.tasks.todolist.entity.ToDo;
import com.tasks.todolist.repository.ToDoRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepo toDoRepo;

    public ToDoService(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    public List<ToDo> getToDoRepo() {
        return toDoRepo.findAll();
    }
    public String addToDo(ToDo toDo){
        toDoRepo.save(toDo);
        return "success";
    }
    public String deleteToDo(long id){
       ToDo deleted=toDoRepo.findById(id).orElse(null);
        toDoRepo.delete(deleted);
        return "success";
    }
}
