package com.heaven.webapp.controller;

import com.heaven.webapp.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")

public class TodoResource {
    @Autowired
    private ToDoService service;
    @GetMapping("/users/{username}/todos")
    public ResponseEntity<?> retrieveTodos(@PathVariable("username")String username){
       return new ResponseEntity<>(service.getTodos(username), HttpStatus.OK);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public ResponseEntity<?> retrieveTodo(@PathVariable("username")String username,
    @PathVariable("id")Integer id){
        return new ResponseEntity<>(service.findById(username,id), HttpStatus.OK);
    }

    @DeleteMapping ("/users/{username}/todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable("username")String username,
                                        @PathVariable("id")Integer id){
        service.deleteToDo(id);
        return ResponseEntity.noContent().build();
    }
}
