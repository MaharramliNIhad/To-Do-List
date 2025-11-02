package com.tasks.todolist.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequest {
   private String name;
   private String surname;

   public String getName() {
      return name;
   }

   public UserRequest setName(String name) {
      this.name = name;
      return this;
   }

   public String getSurname() {
      return surname;
   }

   public UserRequest setSurname(String surname) {
      this.surname = surname;
      return this;
   }
}
