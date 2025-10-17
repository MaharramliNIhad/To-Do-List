package com.tasks.todolist.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ToDoResponse {
    private String name;
    private String description;
}
