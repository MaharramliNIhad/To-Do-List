package com.tasks.todolist.dto;

public class ToDoRequest {
  private   String name;
  private   String description;

    public String getName() {
        return name;
    }

    public ToDoRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ToDoRequest setDescription(String description) {
        this.description = description;
        return this;
    }
}
