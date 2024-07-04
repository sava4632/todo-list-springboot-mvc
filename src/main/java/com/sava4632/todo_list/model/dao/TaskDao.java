package com.sava4632.todo_list.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.sava4632.todo_list.model.entity.Task;
import com.sava4632.todo_list.model.entity.User;

/**
 * TaskDao is an interface that extends CrudRepository for Task entity.
 */
public interface TaskDao extends CrudRepository<Task, Integer>{
    List<Task> findByUser(User user);
}
