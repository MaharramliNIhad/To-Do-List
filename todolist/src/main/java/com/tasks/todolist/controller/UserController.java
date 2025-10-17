package com.tasks.todolist.controller;

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
    public UserEntity getUserById(@PathVariable Long id) {
        return userService.findById(id);
    } //don't return entity directly

    @PostMapping
    public UserEntity addUser(@RequestBody UserEntity userEntity) {
        //request object must be creation
        //response object must be creation
        return userService.save(userEntity);
    }

    @PatchMapping("/{id}")
    public UserEntity updateUserById(@PathVariable Long id,
                                     @RequestBody UserEntity userEntity) {
        //request object must be creation
        //response object must be creation
        //X
        return userService.save(userEntity);
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id) {
        userService.deleteById(id);
    }
}
