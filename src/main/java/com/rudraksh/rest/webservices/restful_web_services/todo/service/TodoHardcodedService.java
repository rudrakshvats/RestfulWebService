package com.rudraksh.rest.webservices.restful_web_services.todo.service;

import com.rudraksh.rest.webservices.restful_web_services.todo.entity.Todo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static List<Todo> todos = new ArrayList();
    private static int idCounter = 0;

    static {
        todos.add(new Todo(++idCounter, "Rudraksh", "Learn Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "Rudraksh", "Practice Angular", new Date(), false));
        todos.add(new Todo(++idCounter, "Rudraksh", "Master Angular", new Date(), false));
    }

    public List<Todo> findAll() {
        return todos;
    }
}
