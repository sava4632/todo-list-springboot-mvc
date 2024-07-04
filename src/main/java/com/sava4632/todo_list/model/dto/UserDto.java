package com.sava4632.todo_list.model.dto;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Class to represent a user data transfer object (DTO)
 */
@Data
@ToString
@Builder
public class UserDto implements Serializable{
    private Integer id;
    private String username;
    private String email;
    private String password;
}
