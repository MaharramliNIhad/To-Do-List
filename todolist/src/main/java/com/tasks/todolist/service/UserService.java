package com.tasks.todolist.service;

import com.tasks.todolist.entity.User;
import com.tasks.todolist.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> findAll() {
        return userRepo.findAll();
    }
    public User findById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    public User save(User user) {
        return userRepo.save(user);
    }
    public void update(Long id,User user) {
User u = userRepo.findById(id).orElse(null);
u.setName(user.getName());
u.setSurname(user.getSurname());
    }
    public void updateUserPartially(Long id,User user) {
        User u = userRepo.findById(id).orElse(null);
        if (u.getName() != null) {
            u.setName(user.getName());
        }
        if (u.getSurname() != null) {
            u.setSurname(user.getSurname());
        }
        userRepo.save(u);
    }
    public void delete(Long id) {
        userRepo.deleteById(id);
    }
}
