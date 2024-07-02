package com.sava4632.todo_list.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sava4632.todo_list.model.dao.UserDao;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.service.IUser;

@Service // Spring annotation to mark this class as a service
public class UserImpl implements IUser{

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Transactional(readOnly = true) // read only transaction to avoid dirty reads
    @Override
    public User findById(Integer id) {
        return userDao.findById(id).orElse(null);
    }

    @Transactional
    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

}
