package com.sava4632.todo_list.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sava4632.todo_list.model.dao.UserDao;
import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.service.IUserService;

@Service // Spring annotation to mark this class as a service
public class UserImplService implements IUserService{

    @Autowired
    private UserDao userDao;

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

    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return userDao.existsById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> listAll() {
        return (List<User>) userDao.findAll();
    }

}
