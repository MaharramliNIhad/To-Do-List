package com.tasks.todolist.exeption;

public class ToDoListNotFoundExeption extends RuntimeException{

    public ToDoListNotFoundExeption(String message){
        super(message);
    }
}
