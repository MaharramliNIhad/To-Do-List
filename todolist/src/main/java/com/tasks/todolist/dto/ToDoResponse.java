package com.tasks.todolist.dto;

public class ToDoResponse {
    private String name;
    private String description;

    public String getName() {
        return name;
    }

    public ToDoResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDoResponse setDescription(String description) {
        this.description = description;
        return this;
    }
}
