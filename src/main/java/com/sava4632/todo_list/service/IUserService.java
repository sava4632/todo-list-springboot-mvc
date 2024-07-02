package com.sava4632.todo_list.service;


import java.util.List;

import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.User;

public interface IUserService {

    /**
     * List all users from database
     * @return List of all users
     */
    List<User> listAll();

    /**
     * Save user to database
     * @param userDto User object to save
     * @return User object saved
     */
    User save(UserDto userDto);

    /**
     * Find user by id from database
     * @param id User id to find
     * @return User object found by id
     */
    User findById(Integer id);

    /*
     * Find user by id from database 
     */
    void delete(User user);

    /**
     * Check if user exists by id
     * @param id User id to check
     * @return true if user exists, false otherwise
     */
    boolean existsById(Integer id);
}
