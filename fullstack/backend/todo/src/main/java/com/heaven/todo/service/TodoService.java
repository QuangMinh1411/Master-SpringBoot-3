package com.heaven.todo.service;

import com.heaven.todo.entity.Todo;
import com.heaven.todo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository repo;

    public List<Todo> findByUsername(String username) {
        return repo.findByUsername(username);
    }

    public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
        Todo todo = new Todo(null, username, description, targetDate, done);
        repo.save(todo);
        return todo;
    }

    public void deleteById(int id) {
        repo.deleteById(id);
    }

    public Todo findById(int id) {
        return repo.findById(id).orElse(null);
    }

    public Todo updateTodo(Integer id, Todo todo) {
        Todo exist = findById(id);
        exist.setDescription(todo.getDescription());
        exist.setTargetDate(todo.getTargetDate());
        repo.save(exist);
        return exist;
    }
}
