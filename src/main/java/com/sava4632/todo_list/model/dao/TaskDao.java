package com.sava4632.todo_list.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.sava4632.todo_list.model.entity.Task;

/**
 * TaskDao is an interface that extends CrudRepository for Task entity.
 */
public interface TaskDao extends CrudRepository<Task, Integer>{

}
