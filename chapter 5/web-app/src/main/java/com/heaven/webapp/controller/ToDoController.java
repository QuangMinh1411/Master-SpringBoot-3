package com.heaven.webapp.controller;

import com.heaven.webapp.entity.Todo;
import com.heaven.webapp.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ToDoController {

    private final ToDoService service;
    @GetMapping("/list")
    public String listAll(Model model){
        String username = getLoggedInUsername(model);
        List<Todo> list = service.getTodos(username);
        model.addAttribute("name",username);
        model.addAttribute("todos",list);
        return "listTodos";
    }
    @GetMapping("/add-to-do")
    public String addToDo(Model model){
        model.addAttribute("todo",new Todo());
        return "toDoForm";
    }
    @PostMapping("/add")
    public String addNewToDo(@Valid @ModelAttribute("todo") Todo todo,BindingResult bindingResult,Model model){
        if(bindingResult.hasErrors()){
            //Must add model attribute to the form
            model.addAttribute("todo",todo);
            return "todoForm";
        }

        todo.setUsername(getLoggedInUsername(model));
        service.addTodo(todo);
        return "redirect:/list";

    }

    @GetMapping("/delete")
    public String deleteToDo(@RequestParam("id") Integer id,Model model){
        service.deleteToDo(id);
        return "redirect:/list";
    }

    @GetMapping("/edit/{id}")
    public String updateToDo(@PathVariable("id") Integer id, Model model){
        model.addAttribute("todo",service.findById("heavenlight",id));
        return "todoForm";
    }

    private String getLoggedInUsername(Model model){
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
