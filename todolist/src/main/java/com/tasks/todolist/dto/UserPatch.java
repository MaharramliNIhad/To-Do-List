package com.tasks.todolist.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class UserPatch {
    String name;
    String surname;

    public String getName() {
        return name;
    }

    public UserPatch setName(String name) {
        this.name = name;
        return this;
    }

    public String getSurname() {
        return surname;
    }

    public UserPatch setSurname(String surname) {
        this.surname = surname;
        return this;
    }
}
