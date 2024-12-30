package com.rudraksh.rest.webservices.restful_web_services.todo.resource;

import com.rudraksh.rest.webservices.restful_web_services.todo.entity.Todo;
import com.rudraksh.rest.webservices.restful_web_services.todo.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }
}