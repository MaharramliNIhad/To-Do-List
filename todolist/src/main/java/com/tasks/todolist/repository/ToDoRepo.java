package com.tasks.todolist.repository;

import com.tasks.todolist.entity.ToDoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepo extends JpaRepository<ToDoEntity,Long> {
}
