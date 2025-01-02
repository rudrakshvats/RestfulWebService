package com.rudraksh.rest.webservices.restful_web_services.todo.resource;

import com.rudraksh.rest.webservices.restful_web_services.todo.entity.Todo;
import com.rudraksh.rest.webservices.restful_web_services.todo.repositories.TodoJpaRepository;
import com.rudraksh.rest.webservices.restful_web_services.todo.service.TodoHardcodedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TodoJPAResource {

    @Autowired
    private TodoHardcodedService todoHardcodedService;

    @Autowired
    private TodoJpaRepository todoJpaRepository;

    @GetMapping(path = "/jpa/users/{username}/todos")
    public List<Todo> getAllTodos(@PathVariable String username) {
        //return todoHardcodedService.findAll();
        return todoJpaRepository.findByUsername(username);
    }

    @GetMapping(path = "/jpa/users/{username}/todos/{id}")
    public Todo getTodo(@PathVariable String username, @PathVariable long id) {
        //return todoHardcodedService.findById(id);
        return todoJpaRepository.findById(id).orElse(null);
    }

    @DeleteMapping(path = "/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
        Todo todo = todoHardcodedService.deleteById(id);
        if (null != todo) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/jpa/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id, @RequestBody Todo todo) {
        Todo updatedTodo = todoHardcodedService.saveTodo(todo);
        return new ResponseEntity<Todo>(updatedTodo, HttpStatus.OK);
    }

    @PostMapping(path = "/jpa/users/{username}/todos")
    public ResponseEntity<Void> saveTodo(@PathVariable String username, @RequestBody Todo todo) {
        Todo newTodo = todoHardcodedService.saveTodo(todo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newTodo.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}