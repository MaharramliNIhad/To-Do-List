package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.ToDoRequest;
import com.tasks.todolist.dto.ToDoResponse;
import com.tasks.todolist.entity.ToDo;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T13:28:37+0400",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class MapperImpl implements Mapper {

    @Override
    public ToDoResponse ToDoToToDoResponse(ToDo toDo) {
        if ( toDo == null ) {
            return null;
        }

        ToDoResponse toDoResponse = new ToDoResponse();

        toDoResponse.setName( toDo.getName() );
        toDoResponse.setDescription( toDo.getDescription() );

        return toDoResponse;
    }

    @Override
    public ToDo ToDoRequestToToDo(ToDoRequest toDoRequest) {
        if ( toDoRequest == null ) {
            return null;
        }

        ToDo toDo = new ToDo();

        toDo.setName( toDoRequest.getName() );
        toDo.setDescription( toDoRequest.getDescription() );

        return toDo;
    }
}
