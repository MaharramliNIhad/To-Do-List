package com.tasks.todolist.controller;

import com.tasks.todolist.entity.UserEntity;
import com.tasks.todolist.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("//v1/users")
public class UserController {
   private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
        @GetMapping
    public List<UserEntity> getUserList() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }

    @PatchMapping("/{id}")
    public UserEntity updateUser(@PathVariable Long id, @RequestBody UserEntity userEntity) {
        return userService.save(userEntity);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
