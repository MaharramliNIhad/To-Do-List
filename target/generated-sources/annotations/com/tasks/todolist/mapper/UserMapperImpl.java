package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.UserPatch;
import com.tasks.todolist.dto.UserRequest;
import com.tasks.todolist.dto.UserResponse;
import com.tasks.todolist.entity.UserEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-01T01:33:04+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserResponse toUserResponse(UserEntity user) {
        if ( user == null ) {
            return null;
        }

        UserResponse userResponse = new UserResponse();

        return userResponse;
    }

    @Override
    public UserEntity toUserEntity(UserRequest userRequest) {
        if ( userRequest == null ) {
            return null;
        }

        UserEntity userEntity = new UserEntity();

        return userEntity;
    }

    @Override
    public UserEntity updateUserFromPatch(UserPatch dto, UserEntity UserEntity) {
        if ( dto == null ) {
            return UserEntity;
        }

        return UserEntity;
    }
}
