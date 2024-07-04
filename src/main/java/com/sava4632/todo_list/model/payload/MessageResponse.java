package com.sava4632.todo_list.model.payload;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * Class to represent a message response from the server
 */
@Data
@ToString
@Builder
public class MessageResponse implements Serializable{
    private String message;
    private Object object;
}
