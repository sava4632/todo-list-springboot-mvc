package com.sava4632.todo_list.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.sava4632.todo_list.model.entity.User;

/**
 * UserDao is an interface that extends CrudRepository for User entity.
 */
public interface UserDao extends CrudRepository<User, Integer> {
    /**
     * search a user by an email from database
     * @param email the email to search user
     * @return the user found | null
     */
    User findByEmail(String email);
}
