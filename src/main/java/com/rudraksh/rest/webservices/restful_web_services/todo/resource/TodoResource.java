package com.rudraksh.rest.webservices.restful_web_services.todo.resource;

import com.rudraksh.rest.webservices.restful_web_services.todo.entity.Todo;
import com.rudraksh.rest.webservices.restful_web_services.todo.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoResource {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @GetMapping(path = "/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        return todoHardcodedService.findAll();
    }

    @DeleteMapping(path = "/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardcodedService.deleteById(id);
        if (null != todo) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}