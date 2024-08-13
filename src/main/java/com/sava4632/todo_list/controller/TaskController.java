package com.sava4632.todo_list.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sava4632.todo_list.model.dto.TaskDto;
import com.sava4632.todo_list.model.entity.Task;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.model.payload.MessageResponse;
import com.sava4632.todo_list.service.ITaskService;
import com.sava4632.todo_list.service.IUserService;

/**
 * TaskController class to handle the task related requests
 */
@RestController
@RequestMapping("/api/v1")
public class TaskController {

    @Autowired
    private ITaskService taskService;

    @Autowired
    private IUserService userService;

    /**
     * Show all tasks from database
     * 
     * @return List of all tasks
     */
    @GetMapping("/tasks")
    public ResponseEntity<?> showAll() {
        List<Task> tasks = taskService.listAll();

        if (tasks == null || tasks.isEmpty()) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Tasks not found")
                            .object(null)
                            .build(),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Task found successfully")
                        .object(tasks)
                        .build(),
                HttpStatus.OK);
    }

    /**
     * Create task in database
     * @param taskDto Task object to create
     * @return Task created
     */
    @PostMapping("/task")
    public ResponseEntity<?> create(@RequestBody TaskDto taskDto) {
        Task taskSaved = null;

        try {
            taskSaved = taskService.save(taskDto);

            return new ResponseEntity<>(
                    MessageResponse.builder()
                                .message("Task created successfully")
                                .object(TaskDto.builder()
                                    .id(taskSaved.getId())
                                    .title(taskSaved.getTitle())
                                    .description(taskSaved.getDescription())
                                    .isCompleted(taskSaved.getIsCompleted())
                                    .dueDate(taskSaved.getDueDate())
                                    .user(taskSaved.getUser())
                                    .build())
                                .build(),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Failed to create task: " + e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Update task in database
     * @param taskDto Task object to update
     * @param id Task id to update
     * @return Task updated
     */
    @PutMapping("/task/{id}")
    public ResponseEntity<?> update(@RequestBody TaskDto taskDto, @PathVariable Integer id) {
        Task taskUpdated = null;

        try {
            if (taskService.existsById(id)) {
                taskDto.setId(id); // Set the task id to update the task with the given id from the request
                taskUpdated = taskService.save(taskDto);

                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Task updated successfully")
                                .object(TaskDto.builder()
                                        .id(taskUpdated.getId())
                                        .title(taskUpdated.getTitle())
                                        .description(taskUpdated.getDescription())
                                        .isCompleted(taskUpdated.getIsCompleted())
                                        .dueDate(taskUpdated.getDueDate())
                                        .user(taskUpdated.getUser())
                                        .build())
                                .build(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Task not found")
                                .object(null)
                                .build(),
                        HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Failed to update task: " + e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete task from database
     * @param id Task id to delete
     * @return Task deleted
     */
    @DeleteMapping("/task/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Task taskDeleted = null;

        try {
            taskDeleted = taskService.findById(id);
            if (taskDeleted == null) {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Task not found")
                                .object(null)
                                .build(),
                        HttpStatus.NOT_FOUND);
                
            }
            else {
                taskService.delete(taskDeleted);
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Task deleted successfully")
                                .object(TaskDto.builder()
                                        .id(taskDeleted.getId())
                                        .title(taskDeleted.getTitle())
                                        .description(taskDeleted.getDescription())
                                        .isCompleted(taskDeleted.getIsCompleted())
                                        .dueDate(taskDeleted.getDueDate())
                                        .user(taskDeleted.getUser())
                                        .build())
                                .build(),
                        HttpStatus.OK);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Failed to delete task: " + e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Show task by id from database
     * @param id
     * @return
     */
    @GetMapping("/task/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        Task task = taskService.findById(id);

        if (task == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Task not found")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Task found successfully")
                        .object(TaskDto.builder()
                                .id(task.getId())
                                .title(task.getTitle())
                                .description(task.getDescription())
                                .isCompleted(task.getIsCompleted())
                                .dueDate(task.getDueDate())
                                .user(task.getUser())
                                .build())
                        .build(),
                HttpStatus.OK);
    }

    @GetMapping("/task/user/{id}")
    public ResponseEntity<?> showByUserId(@PathVariable Integer id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("User not found")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }
        else{
            List<Task> tasks = taskService.listByUserId(user);

            if (tasks == null || tasks.isEmpty()) {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("Tasks not found")
                                .object(null)
                                .build(),
                        HttpStatus.OK);
            }

            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Task found successfully")
                            .object(tasks)
                            .build(),
                    HttpStatus.OK);
        }
    }
}
