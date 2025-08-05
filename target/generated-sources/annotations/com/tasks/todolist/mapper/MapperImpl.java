package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-05T15:32:55+0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MapperImpl implements Mapper {

    @Override
    public ToDo toDoRequestToToDo(ToDoRequest toDoRequest) {
        if ( toDoRequest == null ) {
            return null;
        }

        ToDo toDo = new ToDo();

        return toDo;
    }

    @Override
    public ToDoResponse ToDoToToDoResponse(ToDo toDo) {
        if ( toDo == null ) {
            return null;
        }

        ToDoResponse toDoResponse = new ToDoResponse();

        return toDoResponse;
    }
}
