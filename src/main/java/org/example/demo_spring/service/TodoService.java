package org.example.demo_spring.service;

import org.example.demo_spring.model.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final List<Todo> todos = new ArrayList<>();

    public TodoService() {
        Todo t1 = new Todo();
        t1.setName("Daniel");
        t1.setDescription("Suis le cours");
        t1.setIsDone(true);

        Todo t2 = new Todo();
        t2.setName("Toto");
        t2.setDescription("Achete du pain");
        t2.setIsDone(false);

        todos.add(t1);
        todos.add(t2);
    }

    public List<Todo> getAllTodos() {
        return todos;
    }

    public Todo getFirstTodo() {
        return todos.isEmpty() ? null : todos.get(0);
    }
}
