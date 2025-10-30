package com.tasks.todolist.service;

import com.tasks.todolist.dto.UserPatch;
import com.tasks.todolist.dto.UserRequest;
import com.tasks.todolist.dto.UserResponse;
import com.tasks.todolist.entity.UserEntity;
import com.tasks.todolist.exeption.UserNotFoundExeption;
import com.tasks.todolist.mapper.UserMapper;
import com.tasks.todolist.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    public List<UserEntity> findAll() {

        return userRepo.findAll();
    }

    public UserResponse findById(Long id) {
        UserResponse userResponse = userMapper.toUserResponse(userRepo.findById(id).orElseThrow(() -> new UserNotFoundExeption("User not found")));
        return userResponse;
    }


    public void save(UserEntity userRequest) {
//        UserEntity userEntity = userMapper.toUserEntity(userRequest);
         userRepo.save(userRequest);
    }

    public void update(Long id, UserPatch userPatch) {
        UserEntity userEntity = userRepo.findById(id).orElseThrow(()->new UserNotFoundExeption("User Not Found"));
       userRepo.save(userEntity);
    }

    public void updateUserPartially(Long id,String name,String surname) {
        UserEntity userEntity =userRepo.findById(id).map(user-> {
            Optional.ofNullable(name).ifPresent(user::setName);
            Optional.ofNullable(surname).ifPresent(user::setSurname);
            return userRepo.save(user);
        }).orElseThrow(() -> new UserNotFoundExeption("User Not Found"));
    }

     public void deleteById(Long id) {
        findById(id);
        userRepo.deleteById(id);
    }
}
