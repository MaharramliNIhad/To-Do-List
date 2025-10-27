package com.tasks.todolist.service;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDoEntity;
import com.tasks.todolist.mapper.ToDoMapper;
import com.tasks.todolist.repository.ToDoRepo;
import com.tasks.todolist.exeption.ToDoListNotFoundExeption;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class ToDoServiceMultiThread {

    private final ToDoRepo toDoRepo;
    private final ToDoMapper toDoMapper;
    public ToDoServiceMultiThread(ToDoRepo toDoRepo, ToDoMapper toDoMapper) {
        this.toDoRepo = toDoRepo;
        this.toDoMapper = toDoMapper;

    }

    @Async
    public CompletableFuture<BaseResponse> getToDoRepo() {
       return CompletableFuture.supplyAsync(() -> {
            List<ToDoEntity> toDoEntityList = toDoRepo.findAll();
            List<ToDoResponse> toDoResponseList = toDoEntityList.stream().map(toDoMapper::toToDoResponse)
                    .collect(Collectors.toList());
            return new BaseResponse().setData(toDoResponseList).setMessage("success").setTimestamp(LocalDateTime.now());
        });
    }

    @Async
    public CompletableFuture<BaseResponse> addToDo(ToDoRequest toDoRequest) {
        return CompletableFuture.supplyAsync(() -> {
            ToDoEntity doRequestToToDoEntity = toDoMapper.toToDoEntity(toDoRequest);
            toDoRepo.save(doRequestToToDoEntity);
             return new BaseResponse().setData(doRequestToToDoEntity).setMessage("success").setTimestamp(LocalDateTime.now());
        });
    }

    @Async
    public CompletableFuture<BaseResponse> deleteToDo(long id) {
        return CompletableFuture.supplyAsync(()->{
            ToDoEntity deleted = toDoRepo.findById(id).orElseThrow(()-> new ToDoListNotFoundExeption("not found") );
            toDoRepo.delete(deleted);
            return new BaseResponse().setData(deleted).setMessage("success").setTimestamp(LocalDateTime.now());

        });
    }

    @Async
    public CompletableFuture<ToDoResponse> getByID(long id) {
        return CompletableFuture.supplyAsync(()->{
            ToDoResponse toDoResponse = toDoMapper.toToDoResponse(toDoRepo.findById(id).orElseThrow(()-> new ToDoListNotFoundExeption("not found")));
            return toDoResponse;
        });
    }

}
