package com.sava4632.todo_list.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sava4632.todo_list.model.dao.UserDao;
import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.service.IUserService;

/**
 * Class to implement the User service interface
 */
@Service // Spring annotation to mark this class as a service
public class UserImplService implements IUserService{

    @Autowired
    private UserDao userDao;

    /**
     * Save or update a user to the database using the userDao
     * @param userDto the user to be saved
     * @return the saved user
     */
    @Transactional
    @Override
    public User save(UserDto userDto) {
        User user = User.builder()
                .id(userDto.getId())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();

        return userDao.save(user);
    }

    /**
     * Find a user by its id
     * @param id the id of the user to be found
     * @return the user if found, null otherwise
     */
    @Transactional(readOnly = true) // read only transaction to avoid dirty reads
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    /**
     * Delete a user from the database
     * @param user the user to be deleted
     */
    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    /**
     * Check if a user exists in the database
     * @param id the id of the user to be checked
     * @return true if the user exists, false otherwise
     */
    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }

    /**
     * List all users in the database
     * @return a list of all users
     */
    @Transactional(readOnly = true)
    @Override
    public List<User> listAll() {
        return (List<User>) userDao.findAll();
    }
}
