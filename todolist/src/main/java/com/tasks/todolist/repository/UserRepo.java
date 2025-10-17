package com.tasks.todolist.repository;

import com.tasks.todolist.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, Long> {
}
