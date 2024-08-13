package com.sava4632.todo_list.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sava4632.todo_list.model.dao.TaskDao;
import com.sava4632.todo_list.model.dto.TaskDto;
import com.sava4632.todo_list.model.entity.Task;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.service.ITaskService;

@Service
public class TaskImplService implements ITaskService{

    @Autowired
    private TaskDao taskDao;

    /**
     * List all tasks from database
     * @return List of all tasks
     */
    @Transactional(readOnly = true)
    @Override
    public List<Task> listAll() {
        return (List<Task>) taskDao.findAll();
    }

    /**
     * Save or update task to database
     * @param taskDto Task object to save or update
     * @return Task object saved or updated
     */
    @Transactional
    @Override
    public Task save(TaskDto taskDto) {
        Task task = Task.builder()
                .id(taskDto.getId())
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .isCompleted(taskDto.getIsCompleted())
                .dueDate(taskDto.getDueDate())
                .user(taskDto.getUser())
                .build();
        return taskDao.save(task);
    }

    /**
     * Find task by id from database
     * @param id Task id to find
     * @return Task object found by id
     */
    @Transactional(readOnly = true)
    @Override
    public Task findById(Integer id) {
        return taskDao.findById(id).orElse(null);
    }

    /**
     * Delete task from database
     * @param task Task object to delete
     * @return Task object deleted
     */
    @Transactional
    @Override
    public void delete(Task task) {
        taskDao.delete(task);
    }

    /**
     * List all tasks by user id from database
     * @param user User object to list tasks
     * @return List of tasks found by user id
     */
    @Transactional(readOnly = true)
    @Override
    public List<Task> listByUserId(User user) {
        //User user = userDao.findById(userDto.getId()).orElse(null);
        return (List<Task>) taskDao.findByUser(user);
    }

    /**
     * Check if task exists by id
     * @param id Task id to check
     * @return True if task exists, false otherwise
     */
    @Transactional(readOnly = true)
    @Override
    public boolean existsById(Integer id) {
        return taskDao.existsById(id);
    }

}
