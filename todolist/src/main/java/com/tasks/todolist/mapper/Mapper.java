package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDo;

@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {
    ToDoResponse ToDoToToDoResponse(ToDo toDo);
ToDo ToDoRequestToToDo(ToDoRequest toDoRequest);
}
