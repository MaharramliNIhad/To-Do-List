package com.tasks.todolist.service;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.entity.ToDoEntity;
import com.tasks.todolist.mapper.ToDoMapper;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.repository.ToDoRepo;
import com.tasks.todolist.exeption.ToDoListNotFoundExeption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ToDoService {

    private final ToDoRepo toDoRepo;
    private final ToDoMapper toDoMapper;



    public synchronized List<ToDoResponse> getToDoRepo() {//getAll - ToDoResponse
        List<ToDoEntity> toDoEntityList = toDoRepo.findAll();
        List<ToDoResponse> toDoResponseList = toDoEntityList.stream().
                map(toDoMapper::toToDoResponse).collect(Collectors.toList());
        return toDoResponseList;
    }

    public synchronized Long addToDo(ToDoRequest toDoRequest) {
        ToDoEntity doRequestToToDoEntity = toDoMapper.toToDoEntity(toDoRequest);
        ToDoEntity save = toDoRepo.save(doRequestToToDoEntity);
        return save.getId();
    }

    public synchronized Long deleteToDo(long id) {
        ToDoEntity deleted = toDoRepo.findById(id).orElse(null);//handle get by id and throw exception when not found
        if (deleted == null) {
            throw new ToDoListNotFoundExeption("Not found");
        }
        toDoRepo.delete(deleted);
        return deleted.getId();
    }

    public synchronized ToDoResponse getByID(long id) {
        ToDoResponse toDoResponse = toDoMapper.toToDoResponse(toDoRepo.findById(id).orElse(null));//x
        if (toDoResponse == null) {
            throw new ToDoListNotFoundExeption("Not Found");
        }
        return toDoResponse;
    }
}
