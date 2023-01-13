package com.heaven.webapp.service;

import com.heaven.webapp.entity.Todo;
import com.heaven.webapp.repository.ToDoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    private final ToDoRepository repo;

    public ToDoService(ToDoRepository repo) {
        this.repo = repo;
    }

    public List<Todo> getTodos(String username){
        return repo.findTodosByUsername(username);
    }

    public void addTodo(Todo todo){
       if(todo.getId() == null){
           todo.setUsername("heavenlight");
            repo.save(todo);
       }
       else {
           Todo exist = findById("heavenlight",todo.getId());
           exist.setDescription(todo.getDescription());
           exist.setTargetDate(todo.getTargetDate());
           exist.setDone(todo.isDone());
           repo.save(exist);
       }
    }

    public Todo findById(String name,Integer id){

        return repo.findTodoByUsernameAndAndId(name,id);
    }

    public void deleteToDo(Integer id){
        repo.deleteById(id);
    }
}
