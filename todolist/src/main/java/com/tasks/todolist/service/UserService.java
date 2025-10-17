package com.tasks.todolist.service;

import com.tasks.todolist.entity.UserEntity;
import com.tasks.todolist.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<UserEntity> findAll() {
        return userRepo.findAll();
    }

    public UserEntity findById(Long id) {
        return userRepo.findById(id).orElse(null);
        //orElseThrow exception when data not found
        //create Exception class and handle it - 404
    }

    public UserEntity save(UserEntity userEntity) {
        return userRepo.save(userEntity); //TODO: add mapping layer
    }

    public void update(Long id, UserEntity userEntity) {
        UserEntity u = userRepo.findById(id).orElse(null);//x
        u.setName(userEntity.getName()); //servicede get set ve object mapping object creation olmali deil - dto, mapping - mapstruct
        u.setSurname(userEntity.getSurname());
    }

    public void updateUserPartially(Long id, UserEntity userEntity) {
        UserEntity u = userRepo.findById(id).orElse(null); //x
        if (u.getName() != null) { //name, surname - @RequestParam String name; --by required true
            u.setName(userEntity.getName()); //@RequestParam PartialUserUpdatedTO - NAME, SURNAME, AGE // v1/users/name=Nihad&surnmae=Maharammli
        }
        if (u.getSurname() != null) {
            u.setSurname(userEntity.getSurname());//-- mapstructa dasi
        }
        userRepo.save(u);
    }

    public void deleteById(Long id) {
        userRepo.deleteById(id); // validate user by id
    }
}



