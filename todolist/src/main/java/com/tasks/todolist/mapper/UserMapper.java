package com.tasks.todolist.mapper;

import com.tasks.todolist.dto.UserPatch;
import com.tasks.todolist.dto.UserRequest;
import com.tasks.todolist.dto.UserResponse;
import com.tasks.todolist.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring",nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserResponse toUserResponse(UserEntity user);
    UserEntity toUserEntity(UserRequest userRequest);
    UserEntity updateUserFromPatch(UserPatch dto, @MappingTarget UserEntity UserEntity);

}
