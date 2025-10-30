package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-10-18T16:36:12+0400",
    comments = "version: 1.6.3, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ToDoMapperImpl implements ToDoMapper {

    @Override
    public ToDoResponse toToDoResponse(ToDoEntity toDoEntity) {
        if ( toDoEntity == null ) {
            return null;
        }

        ToDoResponse toDoResponse = new ToDoResponse();

        return toDoResponse;
    }

    @Override
    public ToDoEntity toToDoEntity(ToDoRequest toDoRequest) {
        if ( toDoRequest == null ) {
            return null;
        }

        ToDoEntity toDoEntity = new ToDoEntity();

        return toDoEntity;
    }
}
