package com.tasks.todolist.controller;

import com.tasks.todolist.dto.UserPatch;
import com.tasks.todolist.dto.UserRequest;
import com.tasks.todolist.dto.UserResponse;
import com.tasks.todolist.entity.UserEntity;
import com.tasks.todolist.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserEntity> getUserList() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    public void addUser(@RequestBody UserEntity userRequest) {
        userService.save(userRequest);
    }

    @PatchMapping("/{id}")
    public void updateUserById(@PathVariable Long id,
                               @RequestParam(required = false)String name,
                               @RequestParam(required = false)String surname) {
         userService.updateUserPartially(id,name,surname);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
