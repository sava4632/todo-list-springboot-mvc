package com.sava4632.todo_list.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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

import com.sava4632.todo_list.model.dto.UserDto;
import com.sava4632.todo_list.model.entity.User;
import com.sava4632.todo_list.model.payload.MessageResponse;
import com.sava4632.todo_list.service.IUserService;

/**
 * Class to represent a user controller to handle user requests
 */
@RestController // Spring annotation to mark this class as a controller
@RequestMapping("/api/v1") // Spring annotation to map the URL to this controller
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * Show all users from database
     * 
     * @return List of all users
     */
    @GetMapping("/users")
    public ResponseEntity<?> showAll() {
        List<User> users = userService.listAll();

        if (users == null || users.isEmpty()) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("Users not found")
                            .object(null)
                            .build(),
                    HttpStatus.OK);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("Users found successfully")
                        .object(users)
                        .build(),
                HttpStatus.OK);
    }

    /**
     * Create user in database
     * 
     * @param userDto User object to create
     * @return User object created
     */
    @PostMapping("/user")
    public ResponseEntity<?> create(@RequestBody UserDto userDto) {
        User userSave = null;
        try {
            userSave = userService.save(userDto);

            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("User created successfully")
                            .object(UserDto.builder()
                                    .id(userSave.getId())
                                    .username(userSave.getUsername())
                                    .password(userDto.getPassword())
                                    .email(userSave.getEmail())
                                    .build())
                            .build(),
                    HttpStatus.CREATED);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Update user by id from database
     * 
     * @param userDto User object to update
     * @param id      User id to update
     * @return User object updated
     */
    @PutMapping("/user/{id}")
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @PathVariable Integer id) {
        User userUpdate = null;

        try {
            if (userService.existsById(id)) {
                userDto.setId(id);
                userUpdate = userService.save(userDto);

                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("User updated successfully")
                                .object(UserDto.builder()
                                        .id(userUpdate.getId())
                                        .username(userUpdate.getUsername())
                                        .password(userUpdate.getPassword())
                                        .email(userUpdate.getEmail())
                                        .build())
                                .build(),
                        HttpStatus.CREATED);
            } else {
                return new ResponseEntity<>(
                        MessageResponse.builder()
                                .message("User not found")
                                .object(null)
                                .build(),
                        HttpStatus.NOT_FOUND);
            }

        } catch (DataAccessException e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Delete user by id from database
     * 
     * @param id User id to delete
     * @return User object deleted
     */
    @DeleteMapping("/user/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        try {
            User userDelete = userService.findById(id);
            userService.delete(userDelete);
            return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException e) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message(e.getMessage())
                            .object(null)
                            .build(),
                    HttpStatus.METHOD_NOT_ALLOWED);
        }
    }

    /*
     * @DeleteMapping("/user/{id}")
     * public ResponseEntity<?> delete(@PathVariable Integer id) {
     * Map<String, Object> response = new HashMap<>(); // Create a map to store the
     * response
     * try {
     * User userDelete = userService.findById(id);
     * userService.delete(userDelete);
     * return new ResponseEntity<>(userDelete, HttpStatus.NO_CONTENT);
     * } catch (DataAccessException e) {
     * response.put("message", e.getMessage()); // Add the error message to the
     * response map
     * response.put("user", null);
     * return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
     * }
     * }
     */

    /**
     * Show user by id from database
     * 
     * @param id User id to find
     * @return User object found by id
     */
    @GetMapping("/user/{id}")
    public ResponseEntity<?> showById(@PathVariable Integer id) {
        User user = userService.findById(id);

        if (user == null) {
            return new ResponseEntity<>(
                    MessageResponse.builder()
                            .message("User not found")
                            .object(null)
                            .build(),
                    HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(
                MessageResponse.builder()
                        .message("User found successfully")
                        .object(UserDto.builder()
                                .id(user.getId())
                                .username(user.getUsername())
                                .password(user.getPassword())
                                .email(user.getEmail())
                                .build())
                        .build(),
                HttpStatus.OK);
    }
}
