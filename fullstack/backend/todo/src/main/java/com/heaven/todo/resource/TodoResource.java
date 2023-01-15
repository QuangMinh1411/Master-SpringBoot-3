package com.heaven.todo.resource;

import com.heaven.todo.entity.Todo;
import com.heaven.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TodoResource {
    private final TodoService todoService;

    @GetMapping("users/{username}/todos")
    public List<Todo> retrieveTodos(@PathVariable String username) {
        return todoService.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveTodo(@PathVariable String username,
                             @PathVariable int id) {
        return todoService.findById(id);
    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username,
                                           @PathVariable int id) {
        todoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,
                           @PathVariable int id, @RequestBody Todo todo) {
        return new ResponseEntity<>(todoService.updateTodo(id,todo), HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public Todo createTodo(@PathVariable String username,
                           @RequestBody Todo todo) {
        Todo createdTodo = todoService.addTodo(username, todo.getDescription(),
                todo.getTargetDate(),todo.isDone() );

        return createdTodo;
    }
}
