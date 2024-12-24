package com.rudraksh.rest.webservices.restful_web_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    //@RequestMapping(method = RequestMethod.GET, path = "/helloWorld")
    @GetMapping(path = "/helloWorld")
    public String helloWorld() {
        return "Hello World";
    }
}
