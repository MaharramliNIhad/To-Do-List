package com.tasks.todolist.dto;

public class ToDoRequest {
   private Long id;
  private   String name;
  private   String description;

    public Long getId() {
        return id;
    }

    public ToDoRequest setId(Long id) {
        this.id = id;
        return this;
    }

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
