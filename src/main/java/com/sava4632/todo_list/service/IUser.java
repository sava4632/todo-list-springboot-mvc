package com.sava4632.todo_list.service;

import com.sava4632.todo_list.model.entity.User;

public interface IUser {

    /**
     * Save user to database
     * @param user User object to save
     * @return User object saved
     */
    User save(User user);

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
}
