package com.heaven.webapp.controller;

import com.heaven.webapp.entity.Todo;
import com.heaven.webapp.service.ToDoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
@SessionAttributes("name")
@RequestMapping("")
public class ToDoController {

    private final ToDoService service;
    @GetMapping("/list")
    public String listAll(Model model){

        List<Todo> list = service.getTodos("heavenlight");
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
        todo.setUsername(model.getAttribute("name").toString());
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
}
