package com.rudraksh.rest.webservices.restful_web_services.controller;

import com.rudraksh.rest.webservices.restful_web_services.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/helloWorldBean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/helloWorld/pathVariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
