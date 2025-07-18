package org.example.demo_spring.controller;


import org.example.demo_spring.model.Todo;
import org.example.demo_spring.service.TodoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/first")
    public Todo getFirstTodo() {
        return todoService.getFirstTodo();
    }


    @GetMapping("/second")
    public List<Todo> getAllTodos() {
        return todoService.getAllTodos();
    }

}
