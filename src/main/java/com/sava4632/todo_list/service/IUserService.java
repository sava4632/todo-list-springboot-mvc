package com.sava4632.todo_list.service;


import java.util.List;

import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.User;

/**
 * Interface to define the methods to be implemented by the User service
 */
public interface IUserService {

    /**
     * List all users from database
     * @return List of all users
     */
    List<User> listAll();

    /**
     * Save or update user to database
     * @param userDto User object to save or update
     * @return User object saved or updated
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
