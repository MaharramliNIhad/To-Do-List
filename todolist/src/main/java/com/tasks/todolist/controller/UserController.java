package com.tasks.todolist.controller;

import com.tasks.todolist.entity.User;
import com.tasks.todolist.service.UserService;
import org.springframework.stereotype.Controller;
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
    public List<User> getUserList() {
        return userService.findAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.findById(id);
    }
    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }
    @GetMapping("/user")
    public User findUserByName(@RequestParam String name) {
        return userService.findByName(name);
    }
    @PatchMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.save(user);
    }
    @DeleteMapping("{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.delete(id);
    }
}
