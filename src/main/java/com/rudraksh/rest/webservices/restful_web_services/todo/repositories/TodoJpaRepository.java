package com.rudraksh.rest.webservices.restful_web_services.todo.repositories;

import com.rudraksh.rest.webservices.restful_web_services.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoJpaRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
