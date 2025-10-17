package com.tasks.todolist.service;

import com.tasks.todolist.dto.BaseResponse;
import com.tasks.todolist.entity.ToDoEntity;
import com.tasks.todolist.mapper.ToDoMapper;
import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.repository.ToDoRepo;
import com.tasks.todolist.exeption.ToDoListNotFoundExeption;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoService {

    private final ToDoRepo toDoRepo;
    private final ToDoMapper toDoMapper;

    public ToDoService(ToDoRepo toDoRepo, ToDoMapper toDoMapper) {
        this.toDoRepo = toDoRepo;
        this.toDoMapper = toDoMapper;
    }

    public synchronized BaseResponse getToDoRepo() {//getAll - ToDoResponse
        List<ToDoEntity> toDoEntityList = toDoRepo.findAll();
        List<ToDoResponse> toDoResponseList = new ArrayList<>();
        for (ToDoEntity toDoEntity : toDoEntityList) {
            toDoResponseList.add(toDoMapper.toToDoResponse(toDoEntity));
        }
        return new BaseResponse().setData(toDoResponseList).setMessage("success").setTimestamp(LocalDateTime.now());
        // write functional programming
        // build custom response dto
    }

    public synchronized BaseResponse addToDo(ToDoRequest toDoRequest) {
        ToDoEntity doRequestToToDoEntity = toDoMapper.toToDoEntity(toDoRequest);
        ToDoEntity save = toDoRepo.save(doRequestToToDoEntity);
        return new BaseResponse().setData(save.getId()).setMessage("success").setTimestamp(LocalDateTime.now());
    }

    public synchronized BaseResponse deleteToDo(long id) {
        ToDoEntity deleted = toDoRepo.findById(id).orElse(null);//handle get by id and throw exception when not found
        if (deleted == null) {
            throw new ToDoListNotFoundExeption("Not found");
        }
        toDoRepo.delete(deleted);
        return new BaseResponse().setData(deleted).setMessage("success").setTimestamp(LocalDateTime.now());
    }

    public synchronized BaseResponse getByID(long id) {
        ToDoResponse toDoResponse = toDoMapper.toToDoResponse(toDoRepo.findById(id).orElse(null));//x
        if (toDoResponse == null) {
            throw new ToDoListNotFoundExeption("Not Found");
        }
        return new BaseResponse().setData(toDoResponse).setMessage("succcess").setTimestamp(LocalDateTime.now());
    }
}
