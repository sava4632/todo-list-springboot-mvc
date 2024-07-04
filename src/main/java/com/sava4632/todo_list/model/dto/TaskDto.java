package com.sava4632.todo_list.model.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.sava4632.todo_list.model.entity.User;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * TaskDto class to represent the task data transfer object
 */
@Data
@ToString
@Builder
public class TaskDto implements Serializable{
    private Integer id;
    private String title;
    private String description;
    private Boolean isCompleted;
    private LocalDate dueDate;
    private User user;
}
