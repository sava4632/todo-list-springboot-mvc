package com.sava4632.todo_list.service;

import java.util.List;

import com.sava4632.todo_list.model.dto.TaskDto;
import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.Task;
import com.sava4632.todo_list.model.entity.User;

/**
 * Interface to define the methods to be implemented by the Task service
 */
public interface ITaskService {
    /**
     * List all tasks from database
     * @return List of all tasks
     */
    List<Task> listAll();

    /**
     * Save or update task to database
     * @param taskDto Task object to save or update
     * @return Task object saved or updated
     */
    Task save(TaskDto taskDto);

    /**
     * Find task by id from database
     * @param id Task id to find
     * @return Task object found by id
     */
    Task findById(Integer id);

    /**
     * Delete task from database
     * @param taskDto Task object to delete
     */
    void delete(Task task);

    /**
     * List all tasks by user id from database
     * @param userId User id to find tasks
     * @return List of tasks found by user id
     */
    List<Task> listByUserId(User user);

    /**
     * Check if task exists by id
     * @param id Task id to check
     * @return True if task exists, false otherwise
     */
    boolean existsById(Integer id);
}
