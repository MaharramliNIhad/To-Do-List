package com.tasks.todolist.service;

import com.tasks.todolist.entity.UserEntity;
import com.tasks.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepo.save(userEntity);
    }

    public void update(Long id, UserEntity userEntity) {
        UserEntity u = userRepo.findById(id).orElse(null);
        u.setName(userEntity.getName());
        u.setSurname(userEntity.getSurname());
    }

    public void updateUserPartially(Long id, UserEntity userEntity) {
        UserEntity u = userRepo.findById(id).orElse(null);
        if (u.getName() != null) {
            u.setName(userEntity.getName());
        }
        if (u.getSurname() != null) {
            u.setSurname(userEntity.getSurname());
        }
        userRepo.save(u);
    }

    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}



