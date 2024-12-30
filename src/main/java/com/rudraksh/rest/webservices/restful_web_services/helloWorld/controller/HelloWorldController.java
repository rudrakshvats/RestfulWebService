package com.rudraksh.rest.webservices.restful_web_services.helloWorld.controller;

import com.rudraksh.rest.webservices.restful_web_services.helloWorld.dto.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200") // this will allow all the requests from the url mentioned to fire our apis
@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }

    @GetMapping(path = "/helloWorldBean")
    public HelloWorldBean helloWorldBean() {
        throw new RuntimeException("Something went wrong! Please try later.");
        //return new HelloWorldBean("Hello World Changed");
    }

    @GetMapping(path = "/helloWorld/pathVariable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
