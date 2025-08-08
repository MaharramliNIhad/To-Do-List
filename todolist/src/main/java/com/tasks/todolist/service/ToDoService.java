package com.tasks.todolist.service;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.mapper.Mapper;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDo;
import com.tasks.todolist.repository.ToDoRepo;
import exeption.ToDoListNotFoundExeption;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepo toDoRepo;
private final Mapper mapper;
    public ToDoService(ToDoRepo toDoRepo, Mapper mapper) {
        this.toDoRepo = toDoRepo;
        this.mapper = mapper;
    }

    public BaseResponse getToDoRepo() {
        List<ToDo> toDoList=toDoRepo.findAll();
        List<ToDoResponse> toDoResponseList=new ArrayList<>();
        for (ToDo toDo:toDoList){
toDoResponseList.add(mapper.ToDoToToDoResponse(toDo));
        }
        return new BaseResponse().setData(toDoResponseList).setMessage("success").setTimestamp(LocalDateTime.now());
    }
    public BaseResponse addToDo(ToDoRequest toDoRequest){
        toDoRepo.save(mapper.toDoRequestToToDo(toDoRequest));
        return new BaseResponse().setData(toDoRequest).setMessage("success").setTimestamp(LocalDateTime.now());
    }
    public BaseResponse deleteToDo(long id){
       ToDo deleted=toDoRepo.findById(id).orElse(null);
       if(deleted==null){
           throw new ToDoListNotFoundExeption("Not found");
       }
        toDoRepo.delete(deleted);
        return new BaseResponse().setData(deleted).setMessage("success").setTimestamp(LocalDateTime.now());
    }
    public BaseResponse getByID(long id){
        ToDoResponse toDoResponse=mapper.ToDoToToDoResponse(toDoRepo.findById(id).orElse(null));
        if (toDoResponse==null){
            throw new ToDoListNotFoundExeption("Not Found");
        }
        return new BaseResponse().setData(toDoResponse).setMessage("succcess").setTimestamp(LocalDateTime.now());
    }
}
