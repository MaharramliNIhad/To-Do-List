package com.tasks.todolist.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoRequest {
    private String name;
    private String description;
}
