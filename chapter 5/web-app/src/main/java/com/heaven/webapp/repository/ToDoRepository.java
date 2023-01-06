package com.heaven.webapp.repository;

import com.heaven.webapp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ToDoRepository extends JpaRepository<Todo,Integer> {
    List<Todo> findTodosByUsername(String name);
}
