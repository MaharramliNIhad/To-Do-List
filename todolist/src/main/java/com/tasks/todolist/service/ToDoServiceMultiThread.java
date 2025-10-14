package com.tasks.todolist.service;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDoEntity;
import com.tasks.todolist.mapper.Mapper;
import com.tasks.todolist.repository.ToDoRepo;
import exeption.ToDoListNotFoundExeption;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
@Service
public class ToDoServiceMultiThread {
    private final ToDoRepo toDoRepo;
    private final Mapper mapper;


    public ToDoServiceMultiThread(ToDoRepo toDoRepo, Mapper mapper) {
        this.toDoRepo = toDoRepo;
        this.mapper = mapper;
    }
@Async
    public   CompletableFuture<BaseResponse> getToDoRepo() {
        List<ToDoEntity> toDoEntityList =toDoRepo.findAll();
        List<ToDoResponse> toDoResponseList=new ArrayList<>();
        for (ToDoEntity toDoEntity : toDoEntityList){
            toDoResponseList.add(mapper.ToDoToToDoResponse(toDoEntity));
        }
return CompletableFuture.completedFuture(new BaseResponse().setData(toDoResponseList).setMessage("success").setTimestamp(LocalDateTime.now()));  }
    @Async
    public CompletableFuture<BaseResponse> addToDo(ToDoRequest toDoRequest) {
        ToDoEntity doRequestToToDoEntity = mapper.ToDoRequestToToDo(toDoRequest);
        toDoRepo.save(doRequestToToDoEntity);
        return CompletableFuture.completedFuture(new BaseResponse().setData(doRequestToToDoEntity).setMessage("success").setTimestamp(LocalDateTime.now()));
    }
    @Async
    public   CompletableFuture<BaseResponse> deleteToDo(long id){
        ToDoEntity deleted=toDoRepo.findById(id).orElse(null);
        if(deleted==null){
            throw new ToDoListNotFoundExeption("Not found");
        }
        toDoRepo.delete(deleted);
        return CompletableFuture.completedFuture(new BaseResponse().setData(deleted).setMessage("success").setTimestamp(LocalDateTime.now()));
    }
    @Async
    public   CompletableFuture<BaseResponse> getByID(long id){
        ToDoResponse toDoResponse=mapper.ToDoToToDoResponse(toDoRepo.findById(id).orElse(null));
        if (toDoResponse==null){
            throw new ToDoListNotFoundExeption("Not Found");
        }
        return CompletableFuture.completedFuture( new BaseResponse().setData(toDoResponse).setMessage("succcess").setTimestamp(LocalDateTime.now()));

}
}
