package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ToDoMapper {

    ToDoResponse toToDoResponse(ToDoEntity toDoEntity);

    ToDoEntity toToDoEntity(ToDoRequest toDoRequest);
}
