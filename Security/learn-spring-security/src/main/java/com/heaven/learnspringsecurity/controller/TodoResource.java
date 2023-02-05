package com.heaven.learnspringsecurity.controller;

import jakarta.annotation.security.RolesAllowed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoResource {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private static final List<Todo> TODO_LIST = List.of(new Todo("heaven","Learn AWS"), new Todo("heaven","Leran Docker"));
    @GetMapping("/todos")
    public List<Todo> retrieveAllTodos(){
        return TODO_LIST;
    }
    @GetMapping("/users/{username}/todos")
    @PreAuthorize("hasRole('USER') and #username==authentication.name")
    public Todo retrieverUser(@PathVariable("username") String username){
        return TODO_LIST.get(0);
    }

    @PostMapping("/users/{username}/todos")
    @RolesAllowed("ADMIN")
    @Secured("ADMIN")
    public void createTodo(@PathVariable("username")String user, @RequestBody Todo todo){
        logger.info("Create {} for {}",todo,user);
    }
}
record Todo(String username,String description){}
